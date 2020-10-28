package com.example.demo.boot.core;


import com.example.demo.boot.restful.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
        return RestResponse.build(e.getCode(), e.getMessage());
    }
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CommonException.class)
    public RestResult<Object> handleRRException(CommonException e) {
        log.error(e.getMessage(), e);
        return RestResponse.build(e.getCode(), e.getMessage());
    }
    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    public RestResult<Object> validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return RestResponse.build(RestCode.FAIL.getCode(), message.toString());
    }
    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return RestResponse.build(RestCode.FAIL.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public RestResult<Object> handleValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return RestResponse.build(RestCode.FAIL.getCode(), e.getCause().getMessage());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public RestResult<Object> handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return RestResponse.build(RestCode.FAIL.getCode(), message.toString());
    }

    //捕捉BeanValidation 非法参数的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResult<Object> handleMethodArgumentNotValidExceptionTypeTwo(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        String errorMsg = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("\n", "[", "]"));
        return RestResponse.build(RestCode.FAIL.getCode(), errorMsg);
    }

    //捕捉BeanValidation 非法参数的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult<Object> handleConstraintViolationExceptionTypeTwo(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        String errorMsg = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n", "[", "]"));
        return RestResponse.build(RestCode.FAIL.getCode(), errorMsg);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public RestResult<Object> handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return RestResponse.build(RestCode.NOT_FOUND.getCode(), "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public RestResult<Object> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return RestResponse.build(RestCode.FAIL.getCode(), "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public RestResult<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return RestResponse.error(RestCode.INTERNAL_SERVER_ERROR);
    }


}
