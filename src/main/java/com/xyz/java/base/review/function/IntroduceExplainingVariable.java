package com.xyz.java.base.review.function;

/**
 * Created by Lenovo on 2019/1/20.
 * 引入解释性变量，目的：简化分解条件表达式
 */
public class IntroduceExplainingVariable {
//    double price() {
//        return quantity * itmePrice - Math.max(0,quantity -500 )* itmePrice * 0.05 + Math.min(quantity*itemPrice*0.1,100.0)
//    }



    // 重构后的价格
//    double price() {
//        // 基本价钱
//        final double basePrice = quantity * itemPrice;
//        // 折扣
//        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
//        // 快递
//        final double shipping = Math.min(basePrice * 0.1, 100.0);
//        // 计算订单价格
//        return basePrice - quantityDiscount + shipping;
//    }
}
