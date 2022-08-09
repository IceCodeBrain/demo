package com.example.demo.boot.restful;

import java.io.Serializable;


/**
 * @description: 通用异常抛出 列如 工具类中的异常抛出  <br>
 * @since: 1.0 <br>
 * @date: 2020/10/21 11:21 <br>
 * @author: PWB <br>
 */
public class CommonException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1213855733833039552L;

    private Integer code;

    public CommonException() {
        super(RestCode.FAIL.getMsg());
        this.code = RestCode.FAIL.getCode();
    }

    public CommonException(String message) {
        super(message);
        this.code = RestCode.FAIL.getCode();
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(RestCode resCode) {
        super(resCode.getMsg());
        this.code = resCode.getCode();
    }

    public CommonException(String message, Throwable cause) {
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
