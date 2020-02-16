package com.xyz.java.base.framework.spring.component;

/**
 * @author gaoxugang
 * @data 2020/1/5  21:16
 * @description 测试bean
 */
public class TestBean {

    private String name;
    private int age;
    private TestBean spouse;
    private String country;


    public TestBean(String name) {
        this.name = name;
    }

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TestBean getSpouse() {
        return spouse;
    }

    public void setSpouse(TestBean spouse) {
        this.spouse = spouse;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", spouse=" + spouse +
                ", country='" + country + '\'' +
                '}';
    }
}
