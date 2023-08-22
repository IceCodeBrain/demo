package com.example.demo.boot.restful;

import java.io.Serializable;


public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1213855733833039552L;

    private Integer code;

    public ServiceException() {
        super(RestCode.FAIL.getMsg());
        this.code = RestCode.FAIL.getCode();
    }

    public ServiceException(String message) {
        super(message);
        this.code = RestCode.FAIL.getCode();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(RestCode resCode) {
        super(resCode.getMsg());
        this.code = resCode.getCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = RestCode.FAIL.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
