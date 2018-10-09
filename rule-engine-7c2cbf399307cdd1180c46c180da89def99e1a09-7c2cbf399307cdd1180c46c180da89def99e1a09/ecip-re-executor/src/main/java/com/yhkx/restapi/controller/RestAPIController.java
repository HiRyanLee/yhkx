package com.yhkx.restapi.controller;

import com.xmair.core.exception.ApiInvokeException;
import com.xmair.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.lang.System.out;

@RestController
@RequestMapping(value = "/restapi")
public class RestAPIController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/get_rest_api_template")
    public void get() throws IOException {
        String url = "http://api.uia.xiamenair.com/internal/api/v1/oauth2/verify?access_token=8d790ecd-629c-4f18-b11c-b31183bc7538&need_user_info=true";
        try {
            String result = HttpUtil.get(url, null);
            out.println(new String(result));
        } catch (ApiInvokeException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/post_rest_api_template")
    public void post() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("plat", "app");
        try {
            String result = HttpUtil.postWithJson("http://11.4.66.30:8080/xmusp-ws/ws/booking/flightSearch", "", headers);
            out.println(new String(result));
        } catch (ApiInvokeException e) {
            e.printStackTrace();
        }

    }
}
