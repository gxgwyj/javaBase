package com.xyz.java.base.jvm;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 分析引用计数法判断对象是否存活的弊端
 */
public class ReferenceTest {
    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        obj1.other = obj2;
        obj2.other = obj1;

        obj1 = null;
        obj2 = null;
        System.gc();


        /**
         * 这段代码是用来验证引用计数算法不能检测出循环引用。
         * 最后面两句将object1和object2赋值为null，也就是说object1和object2指向的对象已经不可能再被访问，
         * 但是由于它们互相引用对方，导致它们的引用计数器都不为0，那么垃圾收集器就永远不会回收它们(内存泄露，永远不能被回收且不能别访问)。
         */

    }
}
