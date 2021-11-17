package com.tw.demoproject.constant;

public enum ErrorType {
    METHOD_ARGUMENT_NOT_VALID(1000),
    TASK_NOT_FOUND(1001),
    TASK_OPERATION_ERROR(1002);

    private Integer errorCode;

    ErrorType(Integer errorCode){
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return errorCode;
    }

}
