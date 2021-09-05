package com.xyz.java.base.jdk7.classloader;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxugang3@jd.com
 * @date 2021/8/27 18:05
 * @description 模拟  PermGen OOM
 *
 * -XX:PermSize=4M -XX:MaxPermSize=4M -verbose:gc
 *
 */
public class PermGenOOM {

    public static void main(String[] args) throws Exception {
        URL url = new File("D:\\gxg_work\\idea_project_self\\javaBase\\jdk7\\target\\classes\\com\\xyz\\java\\base\\jdk7\\classloader").toURL();
        URL[] urls = {url};

        // 获取有关类型加载的JMX接口
        ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();

        // 用于缓存类加载器
        List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();


        while (true) {
            // 加载类型并缓存类加载器实例
            ClassLoader classLoader = new URLClassLoader(urls);
            classLoaders.add(classLoader);
            Class<?> ChildClazz = classLoader.loadClass("com.xyz.java.base.jdk7.classloader.Child");
            Object o = ChildClazz.newInstance();


            //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
            System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
            System.out.println("active: " + loadingBean.getLoadedClassCount());
            System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
        }
    }
}
