package com.xyz.java.base.obj;

import com.xyz.java.base.pojo.User;
import org.junit.Test;

/**
 * 类: ObjectOperate <br>
 * 描述: java对象操作<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月12日 16:33
 */
public class ObjectOperate {
    @Test
    public void hashCodeTest() {
        User user = new User();
        System.out.println("hashCode的值：" + user.hashCode());
        System.out.println("hashCode的二进制值：" + Integer.toBinaryString(user.hashCode()));
    }
}
