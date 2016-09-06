package cola.entity;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author shaofeijin
 *
 */
@Alias("User")
public class User {

    private Integer id;

    private String userName;

    private Integer userState;

    private String userMobile;

    private String userPass;

    public User() {
        super();
    }

    public User(String userName, Integer userState, String userMobile, String userPass) {
        super();
        this.userName = userName;
        this.userState = userState;
        this.userMobile = userMobile;
        this.userPass = userPass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

}
