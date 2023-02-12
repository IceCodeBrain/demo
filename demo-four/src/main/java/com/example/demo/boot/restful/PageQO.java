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
public class PageQO{

  @ApiModelProperty("第几页 默认1 ")
  private Integer pageNum = 1;

  @ApiModelProperty("每页大小 默认 10")
  private Integer pageSize = 10;


  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    if (pageNum == null || pageNum < 1) {
      this.pageNum = 1;
      return;
    }
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    if (pageSize == null || pageSize < 1) {
      this.pageSize = 10;
      return;
    }
    this.pageSize = pageSize;
  }


  @SneakyThrows
  @Override
  public String toString() {
    ObjectMapper om = new ObjectMapper();
    return om.writeValueAsString(this);
  }
}
