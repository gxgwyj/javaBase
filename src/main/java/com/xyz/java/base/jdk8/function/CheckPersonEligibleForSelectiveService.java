package com.xyz.java.base.jdk8.function;

/**
 * @author gaoxugang
 * @data 2021/7/18 0018 15:40
 * @description 筛选性别是男并且年龄在18-25岁之间
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson{
    @Override
    public boolean test(Person person) {
        return person.gender == Person.Sex.MALE && person.getAge() >= 18 && person.getAge() < 30;
    }
}
