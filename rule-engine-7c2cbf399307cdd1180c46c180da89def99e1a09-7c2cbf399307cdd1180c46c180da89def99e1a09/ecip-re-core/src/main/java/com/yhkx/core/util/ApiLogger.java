package com.yhkx.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * 日志记录入口
 *
 * @author LiSs
 * @date on 2018/7/8
 */
public class ApiLogger {

    private static Logger errorLog = LoggerFactory.getLogger("error");
    private static Logger warnLog = LoggerFactory.getLogger("warn");
    private static Logger infoLog = LoggerFactory.getLogger("info");
    private static Logger debugLog = LoggerFactory.getLogger("debug");

    private static Logger redisLog = LoggerFactory.getLogger("redis");
    private static Logger rocketMqLog = LoggerFactory.getLogger("rocketmq");

    public ApiLogger() {
    }

    public static void error(Object msg) {
        if (msg != null) {
            String log = assembleRequestId(msg.toString());
            errorLog.error(log);
        }

    }

    public static void error(String msg, Object... args) {
        msg = assembleRequestId(msg);
        errorLog.error(msg, args);
    }

    public static void error(String msg, Throwable e) {
        msg = assembleRequestId(msg);
        errorLog.error(msg, e);
    }

    public static void warn(Object msg) {
        if (msg != null) {
            String log = assembleRequestId(msg.toString());
            warnLog.warn(log);
        }

    }

    public static void warn(String msg, Object... args) {
        msg = assembleRequestId(msg);
        warnLog.warn(msg, args);
    }

    public static void warn(String msg, Throwable e) {
        msg = assembleRequestId(msg);
        warnLog.warn(msg, e);
    }

    public static void info(Object msg) {
        if (msg != null && infoLog.isInfoEnabled()) {
            String msg1 = assembleRequestId(msg.toString());
            infoLog.info(msg1.toString());
        }

    }

    public static void info(String msg, Object... args) {
        if (infoLog.isInfoEnabled()) {
            msg = assembleRequestId(msg);
            infoLog.info(msg, args);
        }
    }

    public static void redisLog(Object msg, Throwable e) {
        if (msg != null && redisLog.isInfoEnabled()) {
            String msg1 = assembleRequestId(msg.toString());
            redisLog.error(msg1.toString(), e);
        }

    }

    public static void rocketMqLog(Object msg, Throwable e) {
        if (msg != null && rocketMqLog.isInfoEnabled()) {
            String msg1 = assembleRequestId(msg.toString());
            rocketMqLog.info(msg1.toString(), e);
        }

    }

    public static String assembleRequestId(String msg) {
        if (msg != null) {
            msg = assembleRequestId(msg, " ");
        } else {
            msg = assembleRequestId("null", " ");
        }

        return msg;
    }

    private static String assembleRequestId(String msg, String spit) {
        String requestId = getTraceId();
        StringBuilder buf = new StringBuilder(msg);
        if (!StringUtils.isEmpty(requestId)) {
            buf.append(spit).append(requestId);
            msg = buf.toString();
        }

        return msg;
    }

    public static String getTraceId() {
        return MDC.get("traceId");
    }

}
