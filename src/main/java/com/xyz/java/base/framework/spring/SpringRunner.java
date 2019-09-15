package com.xyz.java.base.framework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaoxugang
 * @data 2019/9/15  10:21
 * @description spring容器工具
 */
public class SpringRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
        ((ClassPathXmlApplicationContext) context).start();
    }
}
