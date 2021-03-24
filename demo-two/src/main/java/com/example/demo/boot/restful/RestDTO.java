package com.example.demo.boot.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.SneakyThrows;

/**
 * @description: RestDTO <br>
 * @date: 2021/3/24 16:57 <br>
 * @author: PWB <br>
 */
@ApiModel("分页查询参数 model ")
public class RestDTO<T> {

    @ApiModelProperty("第几页 默认1 ")
    public Integer pageNum = 1;

    @ApiModelProperty("每页大小 默认 20")
    private Integer pageSize = 20;

    @ApiModelProperty("其它查询参数 ")
    private T data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null || pageNum < 1) {
            this.pageNum = 20;
            return;
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = 1;
            return;
        }
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }
}
