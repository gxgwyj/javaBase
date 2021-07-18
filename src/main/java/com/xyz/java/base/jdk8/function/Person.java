package com.xyz.java.base.jdk8.function;

import java.time.LocalDate;

/**
 * @author gaoxugang
 * @data 2021/7/18  0:01
 * @description 定义java类
 */
public class Person {
    public enum Sex{
        MALE,
        FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    /**
     * 计算年龄
     * @return
     */
    public int getAge() {
        return birthday.until(LocalDate.now()).getYears();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPersonInfo() {
        System.out.println(String.format("name=%s,gender=%s,age=%s", name, gender.name(), getAge()));
    }

    public static void main(String[] args) {
        Person gaoxugang = new Person("高旭刚",LocalDate.of(1990,02,28),Sex.MALE,"498869779@qq.com");
        gaoxugang.printPersonInfo();
    }

}
