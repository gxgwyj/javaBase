package com.xyz.java.base.collection;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 类: MyHashMap4java8 <br>
 * 描述: 自己实现HashMap<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月05日 10:23
 */
public class MyHashMap4java8<K, V> {
    /**
     * 默认的初始容量 16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 默认的负载因子（扩容参数） 0.75 也就是当容量达到总容量的四分之三的时候扩容
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 数组的最大长度
     */
    static final float MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 存储HashMap的实际数据结构（实际上是一个数组）
     */
    transient Node<K, V>[] table;

    transient Set<Map.Entry<K, V>> entrySet;

    /**
     * 设定负载因子
     */
    final float loadFactor;

    /**
     * 设定阀值
     */
    int threshold;


    /**
     * 构造方法
     */
    public MyHashMap4java8() {
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    /**
     * HashMap的内部数据结果
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> {
        /**
         * 成员变量
         */
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        /**
         * 构造方法
         *
         * @param hash
         * @param key
         * @param value
         * @param next
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        /**
         * 红黑树形结构
         */
        static final class TreeNode<K, V>{
            TreeNode<K,V> parent;
            TreeNode<K,V> left;
            TreeNode<K,V> right;
            TreeNode<K,V> prev;
            boolean red;
        }

        /**
         * 重写hashCode方法
         *
         * @return
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        /**
         * 重写equals方法
         *
         * @param o
         * @return
         */
        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof MyHashMap4java8.Node) {
                MyHashMap4java8.Node<?, ?> node = (MyHashMap4java8.Node<?, ?>) o;
                if (Objects.equals(key, node.getKey()) && Objects.equals(value, node.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * hash(散列的计算方法)
     *
     * @param key Map的Key值 int 值为32位，向右移动16位，只拿高位的16位进行运算
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * @param hash  根据Key计算的hash值
     * @param key   key值
     * @param value value值
     * @return
     */
    final V putVal(int hash, K key, V value) {
        // 临时数组
        Node<K, V>[] tab;
        Node<K, V> p;
        // 数组长度
        int n;
        // 数组索引
        int i;

        // 首先判断数组是否为空
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = 1;
        }

        return null;

    }


    final Node<K, V>[] resize() {
        Node<K,V>[] oldTab = table;
        // 原来数组的长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 获取老的阀值
        int oldThr = threshold;
        // 新的容量
        int newCap;
        // 新的负载因子
        int newThr = 0;


        // 这一段代码主要根据数组的原来的容量来改变hashMap集合的阀值、最新容量
        if (oldCap > 0) {
            // 如果当前数组的长度超过设定最大长度，直接返回原来的数组
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                // 如果 新的容量扩大二倍小于最大的容量 && 旧容量大于初始容量，新的阀值扩大二倍
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldCap;
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        // 设置最新的阀值
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }

        // 创建最新的数组空间
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                    }
                }
            }
        }
        return null;
    }

}
