package com.example.demo.controller.common;

import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.model.vo.AreaCodeVO;
import com.example.demo.service.AreaCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @description: 地址编码表(AreaCode)表控制层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:53 <br>
 */

@RequiredArgsConstructor
@Api(tags = "地址编码表相关功能API")
@RestController
@RequestMapping("common/area")
public class AreaCodeController {

    private final AreaCodeService areaCodeService;

    @ApiOperation(value = "获取地址列表")
    @GetMapping("doGetAddress")
    public RestResult<List<AreaCodeVO>> doGetAddress(@RequestParam(required = false, defaultValue = "0") Integer code) {
        return RestResponse.ok(areaCodeService.getAddress(code));
    }

}

