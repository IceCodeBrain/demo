package com.example.demo.boot.comonent.tk;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自己的 Mapper
 * 特别注意，该接口不能被扫描到，否则会出错
 * <p>Title: TkMapper</p>
 * <p>Description: </p>
 *
 * @description: TkMapper <br>
 * @date: 2020/1/10 14:31 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public interface TKMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
