package cxf.client;

import cxf.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * @author andy.hu
 * @date 18/3/29 下午3:05
 * @version V1.0
 */
public class CxfClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:cxf-client.xml");
        HelloService client = (HelloService) context.getBean("helloClient");
        System.out.println(client.sayHello("kongxuan"));
    }

}
