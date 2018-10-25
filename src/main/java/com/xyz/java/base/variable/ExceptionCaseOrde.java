package com.xyz.java.base.variable;

import java.io.IOException;

/**
 * 类: ExceptionCaseOrder <br>
 * 描述: java 异常捕获顺序测试<br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年10月25日 10:52
 */
public class ExceptionCaseOrde {
    public void doSomething() throws IOException {

    }

    public void doBusiness() throws MyException {

    }

    public static void main(String[] args) {
        /**
         * 异常捕获顺序：
         * 在写异常处理的时候，一定要把异常范围小的放在前面，
         * 范围大的放在后面，Exception这个异常的根类一定要放在最后一个catch里面，
         * 如果放在前面或者中间，任何异常都会和Exception匹配的，就会报已捕获到异常的错误。
         *
         */
        ExceptionCaseOrde exceptionCaseOrde = new ExceptionCaseOrde();
        try {
            exceptionCaseOrde.doBusiness();
            exceptionCaseOrde.doSomething();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException myException){
            myException.printStackTrace();
        } catch (Exception baseException) {

        }
    }
}
