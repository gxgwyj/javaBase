package com.xyz.java.base.framework.spring.beans;

/**
 * @author gaoxugang
 * @data 2019/9/15 0015 10:24
 * @description TODO
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Qualifier 注解只是一种过滤手段而已
 */
@Service
@Qualifier("payService")
public class WxPayService implements PayService{
    @Override
    public void doPay() {
        System.out.println("执行微信支付");
    }
}
