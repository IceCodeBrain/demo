package com.example.demo.boot.core.tk;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.ExampleProvider;

import java.util.Set;

/**
 * 批量更新的SqlProvider
 *
 * @author kwah
 */

public class BatchExampleProvider extends ExampleProvider {

    public BatchExampleProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    /**
     * 拼update sql, 使用case when方式，非id为主键
     *
     * @param ms
     * @return
     */
    public String updateBatchByPrimaryKeySelective(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        String idname = "", javaIdname = "";
        for (EntityColumn column : columnList) {
            //获取主键id
            if (column.isId()) {
                idname = column.getColumn();
                javaIdname = column.getEntityField().getName();
                break;
            }

        }

        for (EntityColumn column : columnList) {
            if (!column.isId() && column.isUpdatable()) {
                sql.append("  <trim prefix=\"" + column.getColumn() + " =case\" suffix=\"end,\">");
                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
                sql.append("      <if test=\"i." + column.getEntityField().getName() + "!=null\">");
                sql.append("         when " + idname + "=#{i." + javaIdname + "} then #{i." + column.getEntityField().getName() + "}");
                sql.append("      </if>");
                sql.append("    </foreach>");
                sql.append("  </trim>");
            }
        }

        sql.append("</trim>");
        sql.append("WHERE");
        sql.append(" " + idname + " IN ");
        sql.append("<trim prefix=\"(\" suffix=\")\">");
        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
        sql.append("#{i." + javaIdname + "}");
        sql.append("</foreach>");
        sql.append("</trim>");
        System.out.println(sql.toString());
        return sql.toString();
    }
}

