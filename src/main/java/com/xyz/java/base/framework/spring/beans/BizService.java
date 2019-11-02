package com.xyz.java.base.framework.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void showPayServiceList(){
        for (PayService pay : payServiceList) {
            System.out.println(pay.toString());
        }
    }
}
