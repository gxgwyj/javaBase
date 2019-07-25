package com.xyz.java.base.reference;

/**
 * 类: ReferenceTricks <br>
 * 描述: Reference测试类<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年02月25日 15:14
 */
public class ReferenceTricks {
    public int i;

    /**
     * tricks  方法参数其实是一个（地址变量，即内存地址变量），对原来地址变量的一份拷贝
     * @param tricks
     */
    private static void changeReference(ReferenceTricks tricks) {
        // tricks改变并不会影响原参数（属于原来的一份拷贝，临时变量表，使用的时候需要压入栈）
        tricks = new ReferenceTricks();
        tricks.i = 5;
        System.out.println("新生成的i=" + tricks.i);
    }

    private static void changeInteger(ReferenceTricks r) {
        r.i = 5;
        System.out.println("In changeInteger:" + r.i);
    }


    public static void main(String[] args) {
        ReferenceTricks r = new ReferenceTricks();
        r.i = 0;
        System.out.println("改变【引用值】之前的数据i=" + r.i);
        changeInteger(r);
        System.out.println("改变【引用值】之后的数据i=" + r.i);

        r.i = 0;

        System.out.println("改变【引用】之前的数据i=" + r.i);
        // 本质上是值传递，原来值的一个拷贝，不会影响原来的引用值
        changeReference(r);
        System.out.println("改变【引用】之后的数据i=" + r.i);
    }
}