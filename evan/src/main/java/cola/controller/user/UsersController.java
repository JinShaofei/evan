package cola.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cola.entity.User;
import cola.service.user.UsersService;
import cola.utils.user.UserConstants;

/**
 * 
 * @author shaofeijin
 *
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * to login
     * 
     * @return
     */
    @RequestMapping("toLogin.htm")
    public String toLogin() {

        return "user/login";

    }

    /**
     * to register
     * 
     * @return
     */
    @RequestMapping("toRegister.htm")
    public String toRegister() {

        return "user/register";

    }

    /**
     * 注册
     * 
     * @return
     */
    @RequestMapping("register.htm")
    public String register(@RequestParam(required = true) String userName,
            @RequestParam(required = true) String userMobile, @RequestParam(required = true) String userPass1,
            @RequestParam(required = true) String userPass2) {
        try {
            if(userPass1.equals(userPass2)){
                User u = new User(userName, UserConstants.USER_STATE, userMobile, userPass1);
                this.usersService.saveUser(u);
            }
            return "user/login";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/failReg";
    }

    /**
     * 登录
     * 
     * @return
     */
    @RequestMapping("login.htm")
    public String login(@RequestParam(required = true) String userName,
            @RequestParam(required = true) String passWord) {
        User u = this.usersService.getUserByNamePass(userName, passWord);
        if (u != null) {
            return "redirect:index.htm";
        }
        return null;

    }

}
