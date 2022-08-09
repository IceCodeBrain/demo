package com.example.demo.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.example.demo.boot.component.excel.AreaImport;
import com.example.demo.boot.restful.RestDTO;
import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.boot.uitls.ExcelUtils;
import com.example.demo.model.dto.WeatherInfoDTO;
import com.example.demo.model.excel.AreaWeatherEO;
import com.example.demo.model.vo.WeatherInfoVO;
import com.example.demo.service.WeatherInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 地区天气信息表(WeatherInfo)表控制层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:54 <br>
 */
@Slf4j
@RequiredArgsConstructor
@Api(tags = "地区天气信息表相关功能API")
@RestController
@RequestMapping("admin/info")
public class AdminInfoController {

    private final WeatherInfoService weatherInfoService;

    @ApiOperation("导出天气信息到EXCEL")
    @PostMapping("doExport")
    public void doExportUsers(HttpServletResponse response) {
        List<AreaWeatherEO> weatherEOS = weatherInfoService.exportList();
        if (CollectionUtils.isEmpty(weatherEOS)) {
            return;
        }
        response.setHeader("Cache-Control", "private");
        response.setHeader("Pragma", "private");
        //response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Type", "application/force-download");
        response.setHeader("Content-disposition", "attachment;filename=地区天气信息.xlsx");
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            ExcelUtils.exportExcelStream(weatherEOS, AreaWeatherEO.class, "地区天气信息表", outputStream);
        } catch (IOException e) {
            log.info("导出地区天气信息到EXCEL 失败={}", e.getMessage());
        }
    }

    @ApiOperation("通过Excel批量添加地区信息,返回失败原因列表")
    @PostMapping("doImport")
    public RestResult<List<String>> doImport(@RequestParam MultipartFile file) throws IOException {
        List<String> records = new ArrayList<>();
        EasyExcel.read(file.getInputStream(), AreaWeatherEO.class, new AreaImport(records, weatherInfoService)).sheet().doRead();
        log.info("批量注册失败列表：{}", records);
        return RestResponse.ok(records);
    }


    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("doQueryByPage")
    public RestResult<PageInfo<WeatherInfoVO>> doQueryByPage(@RequestBody RestDTO<Object> dto) {
        return RestResponse.ok(this.weatherInfoService.queryByPage(dto));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("doQueryById/{id}")
    public RestResult<WeatherInfoVO> doQueryById(@PathVariable("id") Integer id) {
        return RestResponse.ok(this.weatherInfoService.queryById(id));
    }


    /**
     * 编辑数据
     *
     * @param dto 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PostMapping("doEdit")
    public RestResult<Boolean> doEdit(@RequestBody WeatherInfoDTO dto) {
        if (dto.getId() == null) {
            return RestResponse.ok(this.weatherInfoService.add(dto));
        }
        return RestResponse.ok(this.weatherInfoService.update(dto));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping("doDeleteById/{id}")
    public RestResult<Boolean> doDeleteById(@PathVariable("id") Integer id) {
        return RestResponse.ok(this.weatherInfoService.deleteById(id));
    }

}

