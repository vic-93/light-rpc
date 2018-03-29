package org.rpc.framework.service;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/29 下午4:04
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String content) {
        System.out.println(content);
        return content;
    }
}
