package rpc.common;

import java.io.Serializable;

/**
 * user实体<br>
 *
 * @author andy.hu
 * @date 18/3/29 下午6:11
 * @version V1.0
 */
public class User implements Serializable {

    private String name;
    private String email;

    public User(){}

    public User(String name,String email){
        this.name =name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
