package com.xyz.java.base.framework.spring;

import com.xyz.java.base.framework.spring.beans.BizService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaoxugang
 * @data 2019/9/15  10:21
 * @description spring容器工具
 */
public class SpringRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-beans.xml");
        ((ClassPathXmlApplicationContext) context).start();
        BizService bean = context.getBean(BizService.class);
        bean.showPayServiceList();
    }
}
