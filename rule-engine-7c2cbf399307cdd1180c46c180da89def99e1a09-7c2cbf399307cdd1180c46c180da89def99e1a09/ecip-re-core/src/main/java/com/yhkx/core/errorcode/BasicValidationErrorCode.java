package com.yhkx.core.errorcode;

/**
 * @Author: uniqu
 * @Date: 2018-9-18 15:35
 * @Description:
 */
public enum BasicValidationErrorCode implements ErrorCode {
    DUPLICATE_ITEM_EXIST(-1000),
    EMPTY_VALUE(-1001),
    DEPENDENCY_DATA_NOT_EXIST(-1002) ;
    private final int number;

    BasicValidationErrorCode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

/*  @Override
    public ErrorLevel getErrorLevel(){
        return ErrorLevel.Warn;
    }*/
}
