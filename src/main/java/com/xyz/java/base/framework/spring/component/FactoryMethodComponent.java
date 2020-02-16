package com.xyz.java.base.framework.spring.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author gaoxugang
 * @data 2020/1/5  21:14
 * @description spring后置处理器
 */

@Component
public class FactoryMethodComponent {

    private static int i;

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        System.out.println("publicInstance");
        return new TestBean("publicInstance");
    }

    /**
     * 以传参的形式构建bean（被spring调用）
     * @param spouse
     * @param country
     * @return
     */
    @Bean
    protected TestBean protectedInstance(
            @Qualifier("public") TestBean spouse,
            @Value("#{privateInstance.age}") String country) {
        System.out.println("protectedInstance");
        System.out.println(spouse.toString());
        TestBean tb = new TestBean("protectedInstance", 1);
        tb.setSpouse(spouse);
        tb.setCountry(country);
        return tb;
    }
    @Bean
    private TestBean privateInstance() {
        System.out.println("privateInstance");
        return new TestBean("privateInstance", i++);
    }
}
