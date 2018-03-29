package org.rpc.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * 指定端口防止被防火墙拦截 <br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午2:35
 */
public class CustomSocketFactory extends RMISocketFactory {

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (0 == port){
            port = 8501;
        }
        return new ServerSocket(port);
    }

}
