package com.example.demo.boot.uitls;


import com.example.demo.boot.restful.CommonException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(sdf);
        objectMapper.setTimeZone(TimeZone.getDefault());
        objectMapper.setSerializationInclusion(Include.ALWAYS);
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 将对象转换为JSON字符串
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new CommonException("对象转换为JSON字符串 异常！", e);
        }
    }

    /**
     * JSON字符串转换为对象 <br>
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new CommonException("JSON字符串转换为对象 异常！", e);
        }
    }

    /**
     * 将Json字符串转换成List
     */
    public static <T> List<T> toObjectList(Class<T> clazz, String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            throw new CommonException("Json字符串转换成List 异常！", e);
        }
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 将JSON字符串转为Map
     */
    public static Map<String, Object> toMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> maps = objectMapper.readValue(json, Map.class);//转成map
            return maps;
        } catch (Exception e) {
            throw new CommonException("JSON字符串转为Map 异常！", e);
        }
    }

}
