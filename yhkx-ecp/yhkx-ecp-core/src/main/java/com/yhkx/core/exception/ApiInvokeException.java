package com.yhkx.core.exception;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 接口调用异常
 *
 * @author LiSs
 */
public class ApiInvokeException extends Exception {

    private String apiUrl;
    private RequestMethod requestMethod;
    private String requestBody;

    public ApiInvokeException(String apiUrl, RequestMethod requestMethod, String requestBody) {
        this.apiUrl = apiUrl;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
