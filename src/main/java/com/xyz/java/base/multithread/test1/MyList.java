package com.xyz.java.base.multithread.test1;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();
    public void add() {
        list.add("高旭刚");
    }
    public int size() {
        return list.size();
    }
}
