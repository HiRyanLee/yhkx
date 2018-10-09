package com.yhkx.restapi.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xmair.core.enums.ExceptionEnum;
import com.xmair.core.exception.BusinessException;
import com.xmair.core.util.ApiLogger;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import org.slf4j.MDC;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class CommonExceptionHandler {

    /**
     * 统一处理bean验证抛出的参数校验异常
     * 参数校验失败，统一采用warn记录日志
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(BindException.class)
    public ResultBean<List<FieldError>> validExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        return new ResultBean<>(ExceptionEnum.ARGUMENTS_INVALID, null, "arguments invalid", fieldErrors);
    }


    /**
     * 统一拦截处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResultBean<String> validExceptionHandler(BusinessException e) throws JsonProcessingException {
        ApiLogger.warn("业务异常：【{}】", e.getMessage(), e);
        ResultBean<String> result = new ResultBean<String>();
        result.setCode(ExceptionEnum.BUSINESS_ERROR.getCode());
        result.setErrStr(e.getErrCode());
        result.setMessage(e.getMessage());
        result.setData(JsonUtil.parseObject2String(e.getData()));
        return result;
    }

    /**
     * 默认统一异常处理方法
     *
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ResultBean<String> runtimeExceptionHandler(Exception e) {
        ApiLogger.error("运行时异常：【{}】", e.getMessage(), e);
        ResultBean<String> result = new ResultBean<String>();
        result.setCode(ExceptionEnum.SERVER_ERROR.getCode());
        result.setMessage(e.getMessage() + "-- traceid:" + MDC.get("traceId"));
        return result;
    }
}
