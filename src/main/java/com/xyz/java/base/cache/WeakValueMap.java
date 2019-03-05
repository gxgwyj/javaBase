package com.xyz.java.base.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * 类: WeakValueMap <br>
 * 描述: <br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年02月28日 16:32
 */
public class WeakValueMap<K,V> extends HashMap<K,Object> {

    private ReferenceQueue<K> queue = new ReferenceQueue<>();

    /**
     * 私有内部类
     * @param <V>
     */
    private class Entry<V> extends WeakReference<V>{
        K key;
        Entry(K key,V value,ReferenceQueue<V> rq) {
            super(value,rq);
            this.key = key;
        }
    }

    /**
     * put值
     * @param key
     * @param value
     */
    public void putX(K key,V value) {
        expungeStaleEntries();
        Entry entry = new Entry(key,value,queue);
        super.put(key,entry);

    }

    /**
     * 获取值
     * @param key
     * @return
     */
    public V getX(Object key) {
        expungeStaleEntries();
        Entry entry = (Entry) super.get(key);
        if (entry != null) {
            return (V) entry.get();
        }
        return null;

    }

    /**
     * 移除值
     * @param key
     */
    public void removeX(K key) {
        expungeStaleEntries();;
        Entry entry = (Entry) super.get(key);
        if (entry != null) {
            entry.clear();
            super.remove(key);
        }
    }


    private void expungeStaleEntries() {
        Entry entry;
        while ((entry = (Entry) queue.poll()) != null) {
            System.out.println("K:"+entry.key.toString());
            System.out.println("V:"+entry.get());
            super.remove(entry.key);
        }
    }
}
