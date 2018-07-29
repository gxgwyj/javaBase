package com.xyz.java.base.regex;

import java.util.regex.Matcher;
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
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matchStr);
        return matcher.matches();
    }

    public static void main(String[] args) {
//        String context = "w";
//        String regex = ".";
//        System.out.println(isMatch(regex, context));

        String context = "123abc";
        String regex = "^[0-9]+abc$";
        System.out.println(isMatch(context,regex));
    }
}
