package com.tw.demoproject.exception.resolver;

import com.tw.demoproject.constant.ErrorType;
import com.tw.demoproject.domain.error.CommonError;
import com.tw.demoproject.util.ErrorMessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonError verifyFailedException(MethodArgumentNotValidException e){
        String errorMessage = ErrorMessageUtil.handlerErrorMessage(e.getAllErrors());
        return new CommonError(ErrorType.METHOD_ARGUMENT_NOT_VALID.getErrorCode(), errorMessage);
    }
}
