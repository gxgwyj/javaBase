package com.xyz.java.base.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * Created by Lenovo on 2018/7/15.
 */
public class RegexUtils {
    /**
     * 工具包：java.util.regex
     * 使用到的类：
     *              Pattern
     *              Matcher
     *              PatternSyntaxException
     */


    public static boolean isMatch(String regex,String matchStr){
        return Pattern.matches(regex,matchStr);
    }

    public static void main(String[] args) {
        String context = "abcefgefg";
        String regex = "abcefgefg";
        System.out.println(isMatch(regex, context));
    }
}
