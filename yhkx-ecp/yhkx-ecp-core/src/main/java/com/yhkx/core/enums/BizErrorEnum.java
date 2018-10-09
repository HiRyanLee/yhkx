package com.yhkx.core.enums;

/**
 * 业务异常错误码
 *
 * @author LiSs
 */
public enum BizErrorEnum {

    /**
     * 内部错误代码记录：
     * 找不到记录 - 404
     * 参数错误   - 401
     */
    NOT_FOUND(404),
    ARGUMENTS_INVALID(401),
    SERVER_ERROR(500);

    private int value;

    BizErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
