package com.example.demo.boot.restful;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.SneakyThrows;

import java.io.Serializable;

/**
 * @author kwah
 * @Description: 返回对象实体
 * @date 2018/4/19 09:43
 */
@ApiModel("返回类")
public class ResResult<T> implements Serializable {

    private static final long serialVersionUID = 3758864789222317092L;

    @ApiModelProperty("状态码")
    public int code;

    @ApiModelProperty("返回消息")
    private String msg;

    @ApiModelProperty("对象")
    private T data;

    public ResResult<T> setCode(ResCode resCode) {
        this.code = resCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResResult<T> setData(T data) {
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