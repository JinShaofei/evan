package cola.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cola.entity.User;

/**
 * index controller
 * 
 * @author shaofeijin
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * to index
     * 
     * @return
     */
    @RequestMapping("index.htm")
    public ModelAndView index(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("index");
        User u = (User) req.getSession().getAttribute("currentUser");
        if (u != null) {
            mv.addObject("u", u);
        }
        return mv;
    }
    
    
    
    /**
     * to about
     * 
     * @return
     */
    @RequestMapping("/about.htm")
    public ModelAndView about(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("about/about");
        User u = (User) req.getSession().getAttribute("currentUser");
        if (u != null) {
            mv.addObject("u", u);
        }
        return mv;
    }
    
}
