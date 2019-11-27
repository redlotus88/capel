package com.c8n.aliyun.terminnology;

/**
 * Synchronized实现原理
 */
public class Synchonized {

    public static Object resource = new Object();


    public static void main(String[] args) {
        /**
         * Synchronized是实现Java同步的一种方法.
         * Synchronized可以作用于对象(不能作用于基础类型int, float等)
         *
         * 对象的Synchronized是通过monitor对象(每一个对象实例都会有一个monitor)来加锁的.
         * 方法上的Synchronized是JVM通过标识ACC_SYNCHRONIZED来识别同步方法的.
         *
         * 参考资料: https://baijiahao.baidu.com/s?id=1612142459503895416&wfr=spider&for=pc
         *
         * 阿里答案: 解决并发情况下数据同步访问的一个很重要的关键字。保证一个共享资源在同一时间只会被一个线程访问到时，
         *          可以在代码中使用synchronized关键字对类或者对象加锁
         */

        synchronized (Synchonized.resource) {
            // 同步块
        }
    }

    /**
     * Synchronized 修饰方法
     */
    public synchronized void increase() {

    }
}
