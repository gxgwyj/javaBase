package com.xyz.java.base.framework.spring;

import com.xyz.java.base.framework.spring.component.BizService;
import com.xyz.java.base.framework.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaoxugang
 * @data 2019/9/15  10:21
 * @description spring容器工具
 */
public class SpringRunner {

    private static final ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext-beans.xml");

    public static void main(String[] args) {
//        runPayServiceList();
        runAddUser();

    }


    public static void runPayServiceList(){
        BizService bean = appContext.getBean(BizService.class);
        bean.showPayServiceList();
    }

    public static void runAddUser(){
        UserService userService = appContext.getBean(UserService.class);
        userService.addUser();
    }





}
