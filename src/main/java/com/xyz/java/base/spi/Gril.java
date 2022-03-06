package com.xyz.java.base.spi;

/**
 * @author gaoxugang
 * @data 2022/3/6  17:42
 * @description TODO
 */
public class Gril implements People{
    @Override
    public void talk() {
        System.out.println("我是个女孩");
    }
}
