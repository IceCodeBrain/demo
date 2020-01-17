package com.example.demo.boot.restful;

import java.io.Serializable;

/**
 * @Description: 业务类异常
 * @author kwah
 * @date 2018/4/20 14:30
 * 
 */
public class ServiceException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1213855733833039552L;

	private Integer code;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Integer code,String message) {
		super(message);
		this.code= code;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}