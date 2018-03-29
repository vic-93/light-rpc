package cxf.service;

import javax.jws.WebService;

/**
 * 〈一句话功能简述〉<br> 
 * @author andy.hu
 * @date 18/3/29 下午3:06
 * @version V1.0
 */
@WebService
public interface HelloService {

    public String sayHello(String content);

}
