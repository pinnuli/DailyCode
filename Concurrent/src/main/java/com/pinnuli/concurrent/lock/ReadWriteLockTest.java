package com.pinnuli.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: linxiaoyi
 * @date: 2020/12/17
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {

    }
}

class Cache<K,V> {
    final Map<K, V> m =
            new HashMap<>();
    final ReadWriteLock rwl =
            new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        // 读缓存
        r.lock();
        try {
            v = m.get(key);
        } finally{
            r.unlock();
        }
        // 缓存中存在，返回
        if(v != null) {
            return v;
        }
        // 缓存中不存在，查询数据库
        w.lock();
        try {
            // 再次验证
            // 其他线程可能已经查询过数据库
            v = m.computeIfAbsent(key, k -> (V) "");
            // 查询数据库
        } finally{
            w.unlock();
        }
        return v;
    }
}