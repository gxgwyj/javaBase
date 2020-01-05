package com.xyz.java.base.framework.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author gaoxugang
 * @data 2019/11/2 0002 23:14
 * @description TODO
 */
@Component
public class BizService {

    @Autowired
    @Qualifier("payService")
    private List<PayService> payServiceList;

    @Autowired
    private Map<String,PayService> payServiceMap;

    @Autowired
    @Qualifier("public")
    private TestBean testBean;


    @Autowired
    private FactoryMethodComponent factoryMethodComponent;

    @Autowired
    private SpringConfiguration springConfiguration;

    public void showPayServiceList() {
        // 调用的是普通方法
        factoryMethodComponent.publicInstance();

        // 调用的是代理方法
        springConfiguration.publicInstance();

        for (PayService pay : payServiceList) {
            System.out.println(pay.toString());
        }
    }

}
