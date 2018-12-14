package com.example.designPatterns.proxyPattern.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeJdkProxy implements InvocationHandler {

    //代理类
    private Object target;

    public Object bind(Object target){
        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("预处理...");
        result = method.invoke(target, args);
        System.out.println("后续处理...");
        return result;
    }
}
