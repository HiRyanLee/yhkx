package com.yhkx.core.errorcode;

/**
 * @Author: uniqu
 * @Date: 2018-9-18 15:35
 * @Description:
 */
public enum BasicOperationErrorCode implements ErrorCode {
    FAIL_TO_INSERT(-2000),
    FAIL_TO_DELETE(-2001),
    FAIL_TO_UPDATE(-2002);
    private final int number;

    BasicOperationErrorCode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

/*    @Override
    public ErrorLevel getErrorLevel(){
        return ErrorLevel.Error;
    }*/
}
