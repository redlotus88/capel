package com.c8n.aliyun.terminnology;

/**
 * Volatile是Java的关键字, 作用于变量定义之上.
 * 它保证了变量在多个线程之间的可见性, 可以有效的避免脏读现象.
 * Volatile在JVM层面上,可以禁止指令重新排序,在双重校验锁实现单例的时候, 也必须要使用volatile关键字来修饰对象.
 *
 * 简书 volatile相关整理: https://www.jianshu.com/p/ccfe24b63d87
 * Volatile可见性实现 基于内存屏障(目的是阻止编译器重排序和处理器重排序).
 *
 */
public class Volatile {

    public static void main(String[] args) {


    }


    /**
     * 正确的双重校验锁 单例模式
     * 因为JVM可能会对指令调用进行性能优化,重新排序, 导致访问一个未初始化的对象.
     * 参考文章: https://www.cnblogs.com/xz816111/p/8470048.html
     */
    static class DoubleCheckedLock {

        private Object lock = new Object();

        private volatile static DoubleCheckedLock instance;

        public static synchronized DoubleCheckedLock getInstance() {
            if (null == instance) {
                synchronized(DoubleCheckedLock.class) {
                    if (null == instance) {
                        instance = new DoubleCheckedLock();
                    }
                }
            }
            return instance;
        }
    }
}
