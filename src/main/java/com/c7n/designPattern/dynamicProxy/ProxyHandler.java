package com.c7n.designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/30 10:06 PM
 * @since 1.0
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        System.out.println("Before invoke : " + method.getName());
        System.out.println(method.invoke(object, objects));
        System.out.println("After invoke : " + method.getName());
        return null;
    }
}
