package com.example.demo.boot.component.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.model.entity.WeatherInfo;
import com.example.demo.model.excel.AreaWeatherEO;
import com.example.demo.service.WeatherInfoService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author PWB
 * @description 地区信息导入
 * @date 2022年05月14日 14:32
 */
@Slf4j
public class AreaImport extends AnalysisEventListener<AreaWeatherEO> {
    private final List<String> standardHeadMap = Lists.newArrayList("地区编码", "地区名称", "天气");
    private final WeatherInfoService weatherInfoService;
    private int count = 0;
    private int commitCount = 0;
    private final List<String> records;
    private final List<WeatherInfo> list;
    private final Date now;

    public AreaImport(List<String> records, WeatherInfoService weatherInfoService) {
        this.records = records;
        this.weatherInfoService = weatherInfoService;
        this.list = Lists.newArrayList();
        this.now = new Date();
    }

    @Override
    public void invoke(AreaWeatherEO areaWeatherEO, AnalysisContext analysisContext) {
        if (0 == analysisContext.readRowHolder().getRowIndex()) {
            return;
        }
        WeatherInfo info = new WeatherInfo();
        info.setCode(areaWeatherEO.getCode());
        info.setName(areaWeatherEO.getName());
        info.setUpdateTime(now);
        info.setCreateTime(now);
        if (!weatherInfoService.existCode(areaWeatherEO.getCode())) {
            list.add(info);
            count++;
        } else {
            records.add("地区编码为[" + areaWeatherEO.getCode() + "]的数据已存在");
        }
        if (count > 0 && count % 500 == 0) {
            String commit = weatherInfoService.batchAdd(list);
            commitCount++;
            if (commit != null) {
                records.add("第" + commitCount + "次批量添加失败，原因" + commit);
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (count % 500 != 0) {
            String commit = weatherInfoService.batchAdd(list);
            commitCount++;
            if (commit != null) {
                records.add("第" + commitCount + "次批量添加失败，原因" + commit);
            }
        }
        log.info("注册完毕！总共注册{}条数据", count);
        log.info("批量添加次数{}", commitCount);
    }

    /**
     * 校验表头
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头校验成功！");
        if (!MapUtils.isEmpty(headMap)) {
            Collection<String> headVal = headMap.values();
            StringBuilder diffBuilder = new StringBuilder().append("字段缺失");
            //差异字段总数
            int diffSize = 0;
            //以模版表头为准
            for (String index : standardHeadMap) {
                if (!headVal.contains(index)) {
                    diffBuilder.append(" ").append(index);
                    diffSize++;
                }
            }
            if (diffSize > 0) {
                log.error(diffBuilder.toString());
                records.add("表头校验失败");
                records.add(diffBuilder.toString());
            } else {
                log.info("表头校验成功！");
            }
        }
    }
}
