package com.xyz.java.base.pojo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author gaoxugang
 * @data 2020/8/2 0002 16:04
 * @description 单例类,单例被序列化后，反序列化的类为
 */
public class Orientation implements Serializable {

    private static final long serialVersionUID = 4638621410503660644L;

    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation(2);


    protected Object readResolve() {
        if (value == 1) {
            return Orientation.HORIZONTAL;
        }
        if (value == 2) {
            return Orientation.VERTICAL;
        }
        return null;
    }


    /**
     * 私有构造方法
     * @param value
     */
    private Orientation(int value) {
        this.value = value;
    }
    private int value;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Orientation orig = Orientation.HORIZONTAL;
        // 内存中创建byte数组字节流
        OutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        // 写入内存
        out.writeObject(orig);

        // 对象读出内存
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray()));
        Orientation object = (Orientation) in.readObject();

        System.out.println(object == orig);

    }

}
