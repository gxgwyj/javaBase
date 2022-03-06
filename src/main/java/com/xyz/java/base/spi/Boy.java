package com.xyz.java.base.spi;

/**
 * @author gaoxugang
 * @data 2022/3/6 0006 17:42
 * @description TODO
 */
public class Boy implements People {
    @Override
    public void talk() {
        System.out.println("我是个男孩");
    }
}
