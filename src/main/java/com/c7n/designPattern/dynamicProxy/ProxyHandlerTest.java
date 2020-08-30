package com.c7n.designPattern.dynamicProxy;

import java.lang.reflect.*;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/30 10:07 PM
 * @since 1.0
 */
public class ProxyHandlerTest {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HelloInterface hello = new ChineseHello();

//        InvocationHandler handler = new ProxyHandler(hello);
//        Class<?> helloProxyClazz =
//                Proxy.getProxyClass(hello.getClass().getClassLoader(), new Class<?>[] {HelloInterface.class});
//        Constructor<?> constructor = helloProxyClazz.getConstructor(InvocationHandler.class);
//
//        HelloInterface proxyHello = (HelloInterface) constructor.newInstance(handler);
//        proxyHello.sayHello();

        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface helloProxy = (HelloInterface) Proxy.newProxyInstance(HelloInterface.class.getClassLoader(), new Class<?>[] {HelloInterface.class}, handler);
        helloProxy.sayHello();

        handler = new ProxyHandler(new EnglishHello());
        helloProxy = (HelloInterface) Proxy.newProxyInstance(HelloInterface.class.getClassLoader(), new Class<?>[] {HelloInterface.class}, handler);
        helloProxy.sayHello();
    }
}
