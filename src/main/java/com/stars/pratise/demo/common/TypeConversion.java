package com.stars.pratise.demo.common;


import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TypeConversion {

    /**
     * List<Map<String, Object>> 到 List<T> 数据转换
     */
    public static <T> List<T> setList(List<Map<String, Object>> srcList, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        srcList.forEach(x -> {
            try {
                T t = clazz.newInstance();
                Field[] fields = t.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!"serialVersionUID".equals(field.getName())) {
                        //设置对象的访问权限，保证对private的属性的访问
                        field.setAccessible(true);
                        //读取配置转换字段名，并从map中取出数据
                        Object v = x.get(field.getName());
                        field.set(t, convert(v, field.getType()));
                    }
                }
                list.add(t);
            } catch (Exception ex) {
                log.error(ex.toString());
            }
        });
        return list;
    }

    /**
     * Field类型转换
     */
    private static <T> T convert(Object obj, Class<T> type) {
        if (obj != null && StrUtil.isNotBlank(obj.toString())) {
            if (type.equals(String.class)) {
                return (T) obj.toString();
            } else if (type.equals(BigDecimal.class)) {
                return (T) new BigDecimal(obj.toString());
            }
            //其他类型转换......
        }
        return null;
    }

    /**
     * 使用 com.fasterxml.jackson.databind.ObjectMapper 进行转换
     */
    static class A {

        public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
            if (map == null) {
                return null;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            Object obj = objectMapper.convertValue(map, beanClass);

            return obj;
        }

        public static Map<?, ?> objectToMap(Object obj) {
            if (obj == null) {
                return null;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            Map<?, ?> mappedObject = objectMapper.convertValue(obj, Map.class);

            return mappedObject;
        }
    }

    /**
     * 使用 org.apache.commons.beanutils 进行转换
     */
    static class B {

        public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
            if (map == null) {
                return null;
            }

            Object obj = beanClass.newInstance();

            org.apache.commons.beanutils.BeanUtils.populate(obj, map);

            return obj;
        }

        public static Map<?, ?> objectToMap(Object obj) {
            if (obj == null) {
                return null;
            }

            return new org.apache.commons.beanutils.BeanMap(obj);
        }

    }

    /**
     * 使用 Introspector 进行转换
     */
    static class C {

        public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
            if (map == null) {
                return null;
            }

            Object obj = beanClass.newInstance();

            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    setter.invoke(obj, map.get(property.getName()));
                }
            }

            return obj;
        }

        public static Map<String, Object> objectToMap(Object obj) throws Exception {
            if (obj == null) {
                return null;
            }

            Map<String, Object> map = new HashMap<String, Object>();

            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter != null ? getter.invoke(obj) : null;
                map.put(key, value);
            }

            return map;
        }

    }

    /**
     * 使用 reflect 进行转换
     */
    static class D {

        public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
            if (map == null) {
                return null;
            }

            Object obj = beanClass.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }

                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }

            return obj;
        }

        public static Map<String, Object> objectToMap(Object obj) throws Exception {
            if (obj == null) {
                return null;
            }

            Map<String, Object> map = new HashMap<String, Object>();

            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }

            return map;
        }
    }
}
