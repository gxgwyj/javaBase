package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类: ConcurrentHashMapOperate <br>
 * 描述: 线程安全的HashMap操作<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月13日 10:52
 */
public class ConcurrentHashMapOperate {

    @Test
    public void mapPutTest() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("key1","value1");
        // 如果不存在则覆盖key1值
        ((ConcurrentHashMap<String, String>) map).putIfAbsent("key1","value2");
        System.out.println(map.get("key1"));
    }
}
