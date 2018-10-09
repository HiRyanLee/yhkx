/*
package com.yhkx.core.configuration.zipkin;

import brave.SpanCustomizer;
import brave.Tracing;
import brave.context.slf4j.MDCCurrentTraceContext;
import brave.http.HttpAdapter;
import brave.http.HttpClientParser;
import brave.http.HttpServerParser;
import brave.http.HttpTracing;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.kafka11.KafkaSender;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * Zipkin作为日志收集系统，有几种默认的传输方式，Http\Kafka\Scribe，在业务量较大的时候，
 * 频繁的Http请求不满足需求，因此引入kafka作为传输数据的方式
 * <p>
 * 虽然OkHttpClient也有异步写入的方式，但是会造成业务服务与zipkin服务耦合
 * 我们采用的Kafka写入不仅性能高，而且业务服务只与kafka耦合，不与zipkin耦合
 *//*

@Configuration
public class ZipkinConfig {

    @Autowired
    private ZipkinProperties zipkinProperties;

    @Bean
    KafkaSender sender() {
        Map<String, String> pro = new HashMap<>();
        //TODO: Q2: acks,retrys设置为1的作用是保证消息一定写入？
        pro.put("acks", "1");
        pro.put("retries", "1");
        return KafkaSender.newBuilder().overrides(pro)
                .bootstrapServers(zipkinProperties.getKafkaHosts())
                .topic(zipkinProperties.getTopic())
                .build();
    }

    @Bean
    AsyncReporter<Span> spanReporter() {
        return AsyncReporter.builder(sender())
                .messageMaxBytes(200000)
                .queuedMaxSpans(500)
                .build();
    }

    */
/**
     * .sampler(Sampler.ALWAYS_SAMPLE) 百分比采样率
     * .currentTraceContext 把trace/span日志打印到ThreadLocal中,这是特别重要的一步
     *
     * @return
     *//*

    @Bean
    Tracing tracing() {
        return Tracing.newBuilder()
                .localServiceName(zipkinProperties.getServiceName())
                .sampler(Sampler.ALWAYS_SAMPLE)
                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "user-name"))
                .currentTraceContext(MDCCurrentTraceContext.create())
                .spanReporter(spanReporter()).build();
    }

    */
/**
     * 他是怎么拦截HTTP请求的呢？
     * 参考WebConfig中的addZipkinInterceptor配置
     * 和OkHttpClient中的配置
     *//*

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
}
*/
