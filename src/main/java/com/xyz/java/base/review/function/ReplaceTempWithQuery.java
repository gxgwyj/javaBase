package com.xyz.java.base.review.function;

/**
 * Created by Lenovo on 2019/1/20.
 * 以查询取代临时变量
 */
public class ReplaceTempWithQuery {


//    public double add() {
//        double basePrice = quantity * _itemPrice;
//        if (basePrice > 1000) {
//            return basePrice * 0.95;
//        } else {
//            return basePrice * 0.98;
//        }
//    }

//    上述函数可以转换成下面的函数
//    public double add() {
//        if (basePrice() > 1000) {
//            return basePrice() * 0.95;
//        } else {
//            return basePrice() * 0.98;
//        }
//    }
//    double basePrice(){
//        return  quantity * _itemPrice;
//    }

}
