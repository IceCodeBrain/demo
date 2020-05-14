package com.example.demo.boot.core;


import com.example.demo.boot.restful.RestCode;
import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.boot.restful.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description: GlobalExceptionHandler 全局异常处理器 <br>
 * @date: 2020/5/14 9:46 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ServiceException.class)
    public RestResult<Object> handleRRException(ServiceException e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(e.getCode(), e.getMessage());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(RestCode.FAIL.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public RestResult<Object> handleValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(RestCode.FAIL.getCode(), e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult<Object> handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(RestCode.FAIL.getCode(), e.getMessage());
    }


    //捕捉BeanValidation 非法参数的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResult<Object> handleMethodArgumentNotValidExceptionTypeTwo(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        String errorMsg = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("\n", "[", "]"));
        return RestResponse.makeRsp(400, errorMsg);
    }

    //捕捉BeanValidation 非法参数的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult<Object> handleConstraintViolationExceptionTypeTwo(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        String errorMsg = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n", "[", "]"));
        return RestResponse.makeRsp(400, errorMsg);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public RestResult<Object> handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public RestResult<Object> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(RestCode.FAIL.getCode(), "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public RestResult<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return RestResponse.makeRsp(500, "系统繁忙,请稍后再试");
    }


}
