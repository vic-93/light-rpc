package org.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午2:19
 */
public interface HelloService extends Remote{

    void say(String content) throws RemoteException;
}
