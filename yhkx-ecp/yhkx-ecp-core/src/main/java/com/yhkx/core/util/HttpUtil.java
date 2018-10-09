package com.yhkx.core.util;

import com.yhkx.core.exception.ApiInvokeException;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSs
 * @date on 2018/7/9
 */
@Component
public class HttpUtil {

    public static Map<String, String> headerMap = new HashMap<>();

    @Autowired
    private RestTemplate restTemplateInit;

    private static RestTemplate restTemplate;

    @PostConstruct
    public void init(){
        restTemplate = restTemplateInit;
    }

    public static String get(String dstUrl, Map<String, Object> parameterMap) throws ApiInvokeException {
        String result;
        try {
            result = restTemplate.getForObject(integrateGetUri(dstUrl, parameterMap), String.class);
        } catch (Exception e) {
            throw new ApiInvokeException(dstUrl, RequestMethod.GET, "");
        }

        return result;
    }

    public static String postWithJson(String dstUrl, String jsonStr, HttpHeaders headers) throws ApiInvokeException {
        String result;
        try {
            headers.set("Content-Type", "application/json;charset=UTF-8");
            HttpEntity<String> entity = new HttpEntity<>(jsonStr, headers);
            result = restTemplate.postForObject(dstUrl, entity, String.class);
        } catch (Exception e) {
            throw new ApiInvokeException(dstUrl, RequestMethod.POST, jsonStr);
        }

        return result;
    }

    public static String integrateGetUri(String url, Map<String, Object> parameterMap) throws URISyntaxException {

        if (parameterMap == null) {
            return url;
        }

        URIBuilder uriBuilder = new URIBuilder(url);

        for (Map.Entry<String, Object> entity : parameterMap.entrySet()) {
            uriBuilder.setParameter(entity.getKey(), entity.getValue().toString());
        }

        return uriBuilder.build().toString();
    }
}
