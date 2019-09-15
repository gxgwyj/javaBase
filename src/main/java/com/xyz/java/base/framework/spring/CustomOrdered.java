package com.xyz.java.base.framework.spring;

import org.springframework.core.Ordered;

/**
 * @author gaoxugang
 * @data 2019/9/15  10:43
 * @description 自定义顺序类
 */
public class CustomOrdered implements Ordered {

    private int order = Ordered.LOWEST_PRECEDENCE;

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
