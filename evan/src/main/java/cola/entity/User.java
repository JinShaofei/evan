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

    private Integer userBalance;

    private Integer userState;

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

    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

}
