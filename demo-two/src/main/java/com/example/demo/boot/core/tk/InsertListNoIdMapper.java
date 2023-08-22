package com.example.demo.boot.core.tk;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * 通用Mapper接口,特殊方法，批量插入，支持批量插入的数据库都可以使用，例如mysql,h2等
 * 批量插入主键不是不是id的
 *
 * @param <T> 不能为空
 * @author kwah
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface InsertListNoIdMapper<T> {


    /**
     * ======如果主键不是id怎么用？==========
     * 假设主键的属性名是uid,那么新建一个Mapper接口如下
     * <pre>
     * public interface InsertUidListMapper<T> {
     * @Options(useGeneratedKeys = true, keyProperty = "uid")
     * @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
     * int insertList(List<T> recordList);
     * }
     * 只要修改keyProperty = "uid"就可以
     *
     * 然后让你自己的Mapper继承InsertUidListMapper<T>即可
     *
     * </pre>
     */
    @Options(useGeneratedKeys = false)
    @InsertProvider(type = SpecialNoIdProvider.class, method = "dynamicSQL")
    int insertNoIdList(List<T> recordList);

}
