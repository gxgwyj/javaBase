package com.xyz.java.base.variable;

/**
 * 成员变量的默认值
 * Created by Lenovo on 2018/10/17.
 */
public class BasicVariableDefaultValue {
    public byte bt;
    public short st;
    public int it;
    public long lon;
    public float ft;
    public double de;
    public char cr;
    public boolean blen;
    public Object object;

    public static void main(String[] args) {
        BasicVariableDefaultValue defaultValue = new BasicVariableDefaultValue();
        System.out.println("byte:"+ defaultValue.bt);
        System.out.println("short:"+ defaultValue.st);
        System.out.println("int:"+ defaultValue.it);
        System.out.println("long:"+ defaultValue.lon);
        System.out.println("float:"+ defaultValue.ft);
        System.out.println("double:"+ defaultValue.de);
        System.out.println("char:"+ defaultValue.cr);
        System.out.println("boolean:"+ defaultValue.blen);
        System.out.println("Object:"+ defaultValue.object);
    }
}
