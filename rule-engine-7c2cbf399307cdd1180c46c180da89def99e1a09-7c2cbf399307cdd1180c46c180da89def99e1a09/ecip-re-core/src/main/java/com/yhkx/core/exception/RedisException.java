package com.yhkx.core.exception;

public class RedisException extends RuntimeException {
    /**
     * redis 操作异常
     *
     * @param op，操作类型,  get, set, hget, hset
     * @param key, redis key
     * @param filed，redis field，如果有
     * @param ex，异常源
     */
    public String op;
    public String key;
    public String filed;

    public RedisException(String op, String key, String filed, String errText) {
        super(String.format("op-%s key-%s,filed-%s error-%s", op, key, filed, errText));
        this.op = op;
        this.key = key;
        this.filed = filed;
    }
}
