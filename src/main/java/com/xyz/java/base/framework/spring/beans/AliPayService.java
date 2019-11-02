package com.xyz.java.base.framework.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author gaoxugang
 * @data 2019/11/2 0002 23:28
 * @description TODO
 */
@Service
@Qualifier("payService")
public class AliPayService implements PayService{
    @Override
    public void doPay() {
        System.out.println("执行支付宝支付");
    }
}
