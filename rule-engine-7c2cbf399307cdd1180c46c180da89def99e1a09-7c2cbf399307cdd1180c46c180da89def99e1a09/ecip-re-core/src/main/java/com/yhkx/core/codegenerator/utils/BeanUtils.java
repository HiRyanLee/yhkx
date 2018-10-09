package com.yhkx.core.codegenerator.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * velocity需要用的对象描述工具
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class BeanUtils {

    /**
     * 获取Bean的字段信息，用于velocity的生成
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> getValueMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            boolean accessFlag = fields[i].isAccessible();
            try {
                fields[i].setAccessible(true);
                Object o = fields[i].get(obj);
                if (o != null) {
                    map.put(varName, o);
                }
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } finally {
                fields[i].setAccessible(accessFlag);
            }
        }
        return map;
    }
}
