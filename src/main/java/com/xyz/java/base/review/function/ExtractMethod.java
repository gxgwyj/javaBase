package com.xyz.java.base.review.function;

/**
 * 重构函数之一:重新组织函数，提炼代码
 * Created by Lenovo on 2019/1/20.
 */
public class ExtractMethod {

    /**
     * 函数提炼前的代码
     * @param amount
//     */
//    public void printOwing(double amount){
//        printBanner();
//        System.out.println("name:" + _name);
//        System.out.println("amount = [" + amount + "]");
//    }

    /**
     * 提炼后的代码
     * @param amount
     */
    public void printOwing(double amount){
        printBanner();
        printDetail(amount);
    }

    private void printDetail(double amount) {
//        System.out.println("name:" + _name);
        System.out.println("amount = [" + amount + "]");
    }


    private void printBanner() {


    }

}
