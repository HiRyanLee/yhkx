package com.yhkx.core.codegenerator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class StringUtils {

    public static final char UNDERLINE = '_';
    public static final Pattern PATTERN = Pattern.compile("_");


    public static String firstChar2UpperCase(String orgStr) {
        StringBuffer sb = new StringBuffer(orgStr);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        orgStr = sb.toString();
        return orgStr;
    }


    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underLineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = PATTERN.matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }
}
