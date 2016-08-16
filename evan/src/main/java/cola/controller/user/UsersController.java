package cola.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
