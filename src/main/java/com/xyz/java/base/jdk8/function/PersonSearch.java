package com.xyz.java.base.jdk8.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author gaoxugang
 * @data 2021/7/18  14:44
 * @description 查询会员信息
 */

public class PersonSearch {

    /**
     * 传入一个人员列表，查找其中年龄大于某个值的人员
     * @param roster
     * @param age
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person el : roster) {
            if (el.getAge() > age) {
                el.printPersonInfo();
            }
        }
    }

    /**
     * 创建一个更加通用的方法，根据年龄区间来查找人员
     * @param roster
     * @param low
     * @param high
     */
    public static void printPersonsWithinAgeRange(List<Person> roster,int low,int high) {
        for (Person el : roster) {
            if (el.getAge() >= low && el.getAge() < high) {
                el.printPersonInfo();
            }
        }
    }

    /**
     * 思考：如果你想通过性别这个属性来搜素人员该怎么办？如果以后Person 里面增加了职位，增加了工资，以后也要根据这些属性来查找人员，那我们是要再根据每一个属性再写
     * 出对应的查找方法吗？将容易变的部分抽离出来
     * <p>
     * 方式一：将选择器单独抽离出来，如创建CheckPerson接口，不同的选择器有不同的实现，如下
     */

    public static void printPersonsCheck(List<Person> roster, CheckPerson checkPerson) {
        for (Person el : roster) {
            if (checkPerson.test(el)) {
                el.printPersonInfo();
            }
        }
    }




    public static void main(String[] args) {
        Person gaoxugang = new Person("高旭刚23", LocalDate.of(1990, 02, 28), Person.Sex.MALE, "498869779@qq.com");
        Person lily = new Person("lily", LocalDate.of(1989, 06, 15), Person.Sex.MALE, "498869779@qq.com");
        Person tom = new Person("tom", LocalDate.of(1995, 05, 30), Person.Sex.MALE, "498869779@qq.com");
        Person jay = new Person("jay", LocalDate.of(1991, 10, 07), Person.Sex.MALE, "498869779@qq.com");
        Person pual = new Person("pual", LocalDate.of(1991, 07, 16), Person.Sex.MALE, "498869779@qq.com");

        List<Person> list = new ArrayList<>();
        list.add(gaoxugang);
        list.add(lily);
        list.add(tom);
        list.add(jay);
        list.add(pual);

        /**
         * 打印年龄超过30岁的人员
         */
        printPersonsOlderThan(list, 30);


        /**
         * 通过使用接口传入的方式
         */
        CheckPerson checkPerson = new CheckPersonEligibleForSelectiveService();
        printPersonsCheck(list, checkPerson);

        /**
         * 通过使用匿名类的方式来执行搜索，但是匿名类也显的有点繁琐
         */
        printPersonsCheck(list, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.gender == Person.Sex.MALE && person.getAge() >= 18 && person.getAge() < 30;
            }
        });

        /**
         * 通过使用Lambda表达式，将所需要执行的逻辑传入方法，看上去更加简洁（对list中某一个元素执行某一个函数操作）
         */
        printPersonsCheck(list,
                (Person person) -> person.gender == Person.Sex.MALE
                        && person.getAge() >= 18 && person.getAge() < 30);

        /**
         * 将lambda表达式以参数的形式传入方法，执行逻辑
         */
        printPersonsWithPredicate(list,
                person -> person.gender == Person.Sex.MALE
                        && person.getAge() >= 18
                        && person.getAge() < 30);

        /**
         * 再次改进，将过滤出来的人员执行的动作也抽象出来
         */
        processPersons(list,
                person -> person.gender == Person.Sex.MALE
                        && person.getAge() >= 18 && person.getAge() < 30,
                person -> person.printPersonInfo());

        processPersonsWithFunction(
                list,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 40,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        processElements(
                list,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        /**
         * 最终使用java8提供的stream+lambda 表达式来执行整个逻辑
         */
        list.stream() // 装换成流
                // 筛选器
                .filter(person -> person.gender == Person.Sex.MALE && person.getAge() >= 18 && person.getAge() <= 30)
                .map(p -> p.getEmailAddress()) // 映射器
                .forEach(email -> System.out.println(email));// 迭代器



    }

    /**
     * CheckPerson 是一个非常简单的函数，是不是都可以不用定义而实现这个检索条件？
     * 使用JDK提供的标准的谓语函数Predicate
     */
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester){
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPersonInfo();
            }
        }
    }

    /**
     *
     * @param roster 人员列表
     * @param tester 过滤条件
     * @param block 过滤出来的人员需要执行的动作
     */
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster,
                                                  Predicate<Person> tester,
                                                  Function<Person, String> mapper,
                                                  Consumer<String> block) {
        for (Person person : roster) {
            if (tester.test(person)) {
                String data = mapper.apply(person);
                block.accept(data);
            }
        }
    }

    /**
     * 使用更加通用的方法
     */
    public static <X,Y> void  processElements(Iterable<X> source,
                                        Predicate<X> tester,
                                        Function <X, Y> mapper,
                                        Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }




}
