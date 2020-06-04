package com.c7n.bestPractice;

/**
 * 单例模式最佳实践
 *
 * 使用双重校验锁实现单例模式, 保证在多线程的环境下只有单一实例的生成.
 */
public class SingletonInstance {

    private volatile static SingletonInstance instance;

    public static synchronized SingletonInstance getInstance() {
        if (null == instance) {
            synchronized(SingletonInstance.class) {
                if (null == instance) {
                    instance = new SingletonInstance();
                }
            }
        }
        return instance;
    }
}
