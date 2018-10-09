package com.yhkx.restapi.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一的错误处理，响应的信息
 *
 * @author LiSs
 * @date on 2018/7/04
 */
@RestController
@RequestMapping(value="/error")
public class HttpErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping
    public String doHandleError() {
        //TODO: 定义需要返回的错误信息
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
