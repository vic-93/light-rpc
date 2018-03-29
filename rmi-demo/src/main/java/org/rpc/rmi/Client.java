package org.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午2:30
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // 服务引入
        HelloService helloService = (HelloService)Naming.lookup("rmi://localhost:8080/helloService");

        // 远程调用
        helloService.say("client call");
    }

}
