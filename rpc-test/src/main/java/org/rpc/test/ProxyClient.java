package org.rpc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午1:51
 */
public class ProxyClient implements InvocationHandler {

    // 需要被代理的类
    private Object object;

    public ProxyClient(Object object) {
        this.object = object;
    }

    // 获取代理对象
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
            new ProxyClient(object));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = new Object();

        // 通讯业务逻辑
        System.out.println("通讯业务逻辑");

        return result;
    }

    public static void main(String[] args) {
        HelloService helloService = (HelloService) ProxyClient.getProxy(new HelloServiceImpl());
        helloService.say("11111");
    }
}
