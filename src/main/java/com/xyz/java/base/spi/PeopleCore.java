package com.xyz.java.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author gaoxugang
 * @data 2022/3/6 0006 17:46
 * @description TODO
 */
public class PeopleCore {
    public static void main(String[] args) {
        ServiceLoader<People> serviceLoader = ServiceLoader.load(People.class);
        Iterator<People> iterator = serviceLoader.iterator();
        boolean notFund = true;
        while (iterator.hasNext()) {
            notFund = false;
            People people = iterator.next();
            people.talk();
        }
        if (notFund){
            System.out.println("未发现具体实现的类");
        }
    }
}
