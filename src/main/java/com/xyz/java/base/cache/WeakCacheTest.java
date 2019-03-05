package com.xyz.java.base.cache;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 类: WeakCacheTest <br>
 * 描述: <br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年02月15日 18:00
 */
public class WeakCacheTest {

    public static void main(String[] args) {
        String str = new String("hello");
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        WeakReference<String> wr = new WeakReference<>(str, rq);
        // 取消"hello" 对象的强引用
        str = null;
        // 如果“hello”对象没有被回收，str1引用“hello”对象
        String str1 = wr.get();
        System.out.println(str1);
        // 假如“hello”对象没有被回收，rq.poll()返回null;
        Reference<? extends String> ref = rq.poll();
    }

}
