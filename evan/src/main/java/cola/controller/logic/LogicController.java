package cola.controller.logic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cola.entity.User;

/**
 * logic
 * 
 * @author shaofeijin
 *
 */
@Controller
public class LogicController {

    /**
     * to dog view
     * 
     * @return
     */
    @RequestMapping("/toDog.htm")
    public ModelAndView toDogView(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("logic/dog");
        User u = (User) req.getSession().getAttribute("currentUser");
        if (u != null) {
            mv.addObject("u", u);
        }
        return mv;
    }

    /**
     * to dog view
     * 
     * @return
     */
    @RequestMapping("/toCat.htm")
    public ModelAndView toCatView(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("logic/cat");
        User u = (User) req.getSession().getAttribute("currentUser");
        if (u != null) {
            mv.addObject("u", u);
        }
        return mv;
    }

    /**
     * toOthers
     * 
     * @return
     */
    @RequestMapping("/toOthers.htm")
    public ModelAndView toOthers(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("logic/others");
        User u = (User) req.getSession().getAttribute("currentUser");
        if (u != null) {
            mv.addObject("u", u);
        }
        return mv;
    }
}
