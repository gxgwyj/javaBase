package com.xyz.java.base.framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author gaoxugang
 * @data 2019/9/15  10:11
 * @description 自定义bean后置处理器
 */
public class CommonBeanPostProcessor extends CustomOrdered implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("CommonBeanPostProcessor-before:" + o.getClass().getSimpleName());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("CommonBeanPostProcessor-after:" + o.getClass().getSimpleName());
        return o;
    }
}
