package cola.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cola.entity.User;
import cola.service.user.UsersService;

/**
 * 
 * @author shaofeijin
 *
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    // /**
    // * add user
    // *
    // * @return
    // * @throws Exception
    // */
    // @RequestMapping("/addUser.htm")
    // public String addUser() throws Exception {
    //
    // this.usersService.addUser();
    //
    // return "users/addUser";
    // }

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
    public String register(@RequestBody(required = true) User user) {
        try {
            this.usersService.saveUser(user);
            return "/index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/failReg";
    }

}
