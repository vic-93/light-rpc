package org.rpc.framework;

import org.rpc.framework.proxy.ProviderReflect;
import org.rpc.framework.service.HelloService;
import org.rpc.framework.service.HelloServiceImpl;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午4:55
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();

        ProviderReflect.Provider(helloService, 8083);

    }

}
