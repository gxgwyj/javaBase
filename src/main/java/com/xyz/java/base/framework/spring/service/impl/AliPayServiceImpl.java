package com.xyz.java.base.framework.spring.service.impl;

import com.xyz.java.base.framework.spring.service.PayService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author gaoxugang
 * @data 2019/11/2 0002 23:28
 * @description TODO
 */
@Service
@Qualifier("payService")
public class AliPayServiceImpl implements PayService {
    @Override
    public void doPay() {
        System.out.println("执行支付宝支付");
    }
}
