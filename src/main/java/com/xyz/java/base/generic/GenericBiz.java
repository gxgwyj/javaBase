package com.xyz.java.base.generic;

/**
 * 泛型的类型查除和强制转换
 * @param <T>
 */
public class GenericBiz<T> {
    private String name;
    private T obj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
