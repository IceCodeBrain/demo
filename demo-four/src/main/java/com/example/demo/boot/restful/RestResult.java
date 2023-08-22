package com.example.demo.boot.restful;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.SneakyThrows;

import java.io.Serializable;


@ApiModel("返回类")
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 3758864789222317092L;

    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("返回消息")
    private String msg;


    @ApiModelProperty("错误提示")
    private String error;

    @ApiModelProperty("对象")
    private T data;

    public RestResult<T> setCode(RestCode restCode) {
        this.code = restCode.getCode();
        return this;
    }

    public String getError() {
        return error;
    }

    public RestResult<T> setError(String error) {
        this.error = error;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RestResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RestResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }
}
