package com.xyz.java.base.multithread.future.jdk;

import java.util.concurrent.Callable;

/**
 * @author gaoxugang
 * @data 2022/4/9  18:59
 * @description 有返回结果的任务，实现Callable接口
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
