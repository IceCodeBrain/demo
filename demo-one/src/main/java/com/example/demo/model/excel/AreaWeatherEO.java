package com.example.demo.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author PWB
 * @description 描述
 * @date 2022年05月14日 14:16
 */
@Data
public class AreaWeatherEO {
    @ExcelProperty(value = "地区编码", index = 0)
    private Integer code;
    @ExcelProperty(value = "地区名称", index = 1)
    private String name;
    @ExcelProperty(value = "天气", index = 2)
    private String info;
}
