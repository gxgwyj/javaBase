package com.xyz.java.base.jdbc;

import java.util.Random;

public class UserMock {
    private static final String[] FIRST_NAMES = {"赵", "钱", "孙", "李", "周", "武", "郑", "高", "王", "张", "田", "牛","刘","马","侯","唐","董","石"};
    private static final String[] LAST_NAMES = {"强", "刚", "宁", "学", "雪", "丽丽", "乐乐", "欢欢", "菲菲", "飞飞", "浩浩", "翠翠","贝贝","小雪","梦","小凯","杰","阳阳","佳佳"};
    private static final char TEL_FIRST = '1';
    private static final char[] TEL_SECONDS = {'3','5','7','8'};

    private static final String[] EN_NAMES = {"Kelly", "May", "Benson", "Paul", "Joyce", "Solomon", "Kenny", "Wesley", "Denny", "Johnny", "Amy", "Roger", "Gloria", "Fred", "Alice", "Randy", "Aurora", "Tina", "Colin"};



    public static int  createCode() {
        Random random = new Random();
        return random.nextInt(20000000);
    }


    public static String createName() {
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        int temp = random.nextInt(100);
        if (temp % 2 == 0) {
            name.append(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]);
            name.append(LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
        } else {
            name.append(EN_NAMES[random.nextInt(EN_NAMES.length)]);
            name.append(random.nextInt(50));
        }

        return name.toString();
    }

    public static String createTel() {
        StringBuilder tel = new StringBuilder();
        tel.append(TEL_FIRST);
        Random rand = new Random();
        // 生成[0,3]区间的值
        tel.append(TEL_SECONDS[rand.nextInt(4)]);
        for (int i = 0; i < 9; i++) {
            int gen = rand.nextInt(10);
            tel.append(gen);
        }
        return tel.toString();
    }

    public static int createBalance() {
        Random rand = new Random();
        // 生成[0,3]区间的值
        return rand.nextInt(1000000);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(createName());
        }
    }


}
