package com.xyz.java.base.generic;

public class GenericBizClient {
    public static void main(String[] args) {
        GenericBiz<String> genericBiz = new GenericBiz<>();
        String obj = genericBiz.getObj();
        obj.charAt(1);
    }
}
