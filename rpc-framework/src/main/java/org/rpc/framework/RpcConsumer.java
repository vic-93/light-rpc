package org.rpc.framework;

import org.rpc.framework.proxy.ConsumerProxy;
import org.rpc.framework.service.HelloService;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午4:56
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService helloService = ConsumerProxy.consume(HelloService.class, "127.0.0.1", 8083);

        for (int i = 0; i < 1000; i++) {
            String content = helloService.say("测试" + i);
            System.out.println(content);
            Thread.sleep(10);
        }
    }
}
