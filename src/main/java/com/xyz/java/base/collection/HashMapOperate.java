package com.xyz.java.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 类: HashMapOperate <br>
 * 描述: HashMap的相关操作<br>
 * 作者:  Administrator<br>
 * 时间: 2018年08月15日 15:21
 */
public class HashMapOperate {

    public static void main(String[] args) {
        putAllMaps();
    }


    /**
     * 将一个map放入另一个map
     */
    public static void putAllMaps() {
        Map<String, String> mapData = new HashMap<>();
        int size = 20;
        for (int i = 0; i < size; i++) {
            String key = "key" + i;
            String value = "value" + i;
            mapData.put(key, value);
        }

        Map<String, String> allData = new HashMap<>();
        allData.putAll(mapData);
    }
}
