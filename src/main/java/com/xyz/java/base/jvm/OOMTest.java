package com.xyz.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxugang
 * @data 2019/8/25 0025 9:51
 * @description TODO
 */
public class OOMTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        // 创建n个1M大小的数组，耗尽内存
        for (int i = 0; i < 10000; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }

}
