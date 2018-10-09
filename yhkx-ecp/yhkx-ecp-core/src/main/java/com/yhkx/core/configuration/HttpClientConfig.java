
package com.yhkx.core.configuration;

import brave.SpanCustomizer;
import brave.Tracing;
import brave.http.HttpAdapter;
import brave.http.HttpClientParser;
import brave.http.HttpServerParser;
import brave.http.HttpTracing;
import brave.okhttp3.TracingInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpClientConfig {

    @Autowired
    HttpTracing httpTracing;
    @Autowired
    public MappingJackson2HttpMessageConverter jsonConverter;

    /**
     * 注入okhttp客户端工具类，全局唯一，共享连接池，线程安全
     */
    @Bean
    Tracing tracing() {
        return Tracing.newBuilder().build();
    }
    @Bean
    HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.newBuilder(tracing)
                .clientParser(new HttpClientParser() {
                    @Override
                    protected <Req> String spanName(HttpAdapter<Req, ?> adapter, Req req) {
                        return adapter.url(req).toString();
                    }

                    @Override
                    public <Req> void request(HttpAdapter<Req, ?> adapter, Req req, SpanCustomizer customizer) {
                        customizer.name(spanName(adapter, req));
                        customizer.tag("url", adapter.url(req));
                        super.request(adapter, req, customizer);
                    }

                })
                .serverParser(new HttpServerParser() {
                    @Override
                    protected <Req> String spanName(HttpAdapter<Req, ?> adapter, Req req) {
                        return adapter.url(req).toString();
                    }

                    @Override
                    public <Req> void request(HttpAdapter<Req, ?> adapter, Req req, SpanCustomizer customizer) {
                        customizer.name(spanName(adapter, req));
                        customizer.tag("url", adapter.url(req));
                        super.request(adapter, req, customizer);
                    }
                })
                .build();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        //注意：只有明确知道服务端支持H2C协议的时候才能使用。添加H2C支持，
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Dispatcher dispatcher = new Dispatcher(
                httpTracing.tracing().currentTraceContext()
                        .executorService(new Dispatcher().executorService())
        );
        //设置连接池大小
        dispatcher.setMaxRequests(1000);
        dispatcher.setMaxRequestsPerHost(200);
        ConnectionPool pool = new ConnectionPool(20, 30, TimeUnit.MINUTES);


        builder.connectTimeout(250, TimeUnit.MILLISECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectionPool(pool)

                .dispatcher(dispatcher)
                //链路监控埋点
                .addNetworkInterceptor(TracingInterceptor.create(httpTracing))
                .retryOnConnectionFailure(false);
        return builder.build();
    }

    @Primary
    @Bean
    public ClientHttpRequestFactory OkHttp3Factory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }


    private AsyncClientHttpRequestFactory AsyncClientHttpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }

    @LoadBalanced
    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate(AsyncClientHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(OkHttp3Factory());
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        xmlConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_XML);
        xmlConverter.setSupportedMediaTypes(list);

        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(jsonConverter);
        restTemplate.setMessageConverters(messageConverters);

        //添加HTTP-Header拦截器，在请求包中添加预期返回的数据格式
        restTemplate.setInterceptors(Collections.singletonList(new JsonHeaderInterceptor()));

        return restTemplate;
    }
}
