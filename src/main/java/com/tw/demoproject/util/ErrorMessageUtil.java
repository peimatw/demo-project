package com.tw.demoproject.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ErrorMessageUtil {
    public static String handlerErrorMessage(Errors errors){
        return handlerErrorMessage(errors.getAllErrors());
    }

    public static String handlerErrorMessage(List<ObjectError> errors){
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : errors){
            stringBuilder.append(error.getDefaultMessage()).append(";");
        }
        return stringBuilder.toString();
    }
}
