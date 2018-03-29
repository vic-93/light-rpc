package org.rpc.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午2:28
 */
public class Server {

    public static void main(String[] args) throws IOException, AlreadyBoundException {
        HelloService helloService = new HelloServiceImpl();

        // 注册
        LocateRegistry.createRegistry(8080);

        RMISocketFactory.setSocketFactory(new CustomSocketFactory());

        Naming.bind("rmi://localhost:8080/helloService", helloService);
        System.out.println("server  ........");
    }

}
