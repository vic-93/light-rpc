package org.rpc.framework.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * 服务发布 <br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午4:39
 */
public class ProviderReflect {

    private final static ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void Provider(final Object service, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            EXECUTOR_SERVICE.execute(new req(socket, service));
        }
    }

    static class req implements Runnable {

        Socket socket;
        Object service;

        public req(Socket socket, Object service) {
            this.socket = socket;
            this.service = service;
        }

        @Override
        public void run() {
            ObjectInputStream in = null;
            ObjectOutputStream out = null;
            try {

                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
                String methodName = in.readUTF();
                Object[] params = (Object[])in.readObject();
                Object result = MethodUtils.invokeExactMethod(service, methodName, params);

                out.writeObject(result);

            } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
