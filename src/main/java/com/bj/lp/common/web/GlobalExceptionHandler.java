package com.bj.lp.common.web;


import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public JsonResult doException(ServiceException e) {
        return new JsonResult(e);
    }
}
