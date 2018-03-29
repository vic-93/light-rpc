package org.rpc.test;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午1:51
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String content) {
        System.out.println(content);
    }
}
