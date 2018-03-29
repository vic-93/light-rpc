package org.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午2:19
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    private static final long serialVersionUID = -6088726812563829081L;

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void say(String content) throws RemoteException{
        System.out.println(content);
    }

}
