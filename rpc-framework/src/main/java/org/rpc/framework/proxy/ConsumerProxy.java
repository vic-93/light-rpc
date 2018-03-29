package org.rpc.framework.proxy;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 服务消费的代理接口 <br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午4:10
 */
public class ConsumerProxy {

    public static <T> T consume(final Class<T> cls, String host, int port) throws Exception{
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new handler(host,port));
    }

    static class handler implements InvocationHandler {

        String host;
        int port;

        public handler(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Socket socket = new Socket(this.host, this.port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            try {
                // 方法名
                out.writeUTF(method.getName());
                // 参数
                out.writeObject(args);

                Object result = in.readObject();
                if (result instanceof Throwable){
                    throw  (Throwable) result;
                }
                return result;
            }finally {
                in.close();
                out.close();
                socket.close();
            }

        }
    }

}
