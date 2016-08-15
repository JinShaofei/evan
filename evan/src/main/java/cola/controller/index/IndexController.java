package cola.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index controller
 * 
 * @author shaofeijin
 *
 */
@Controller
public class IndexController {

    /**
     * to index
     * 
     * @return
     */
    @RequestMapping("/index.htm")
    public String index() {
        return "index/index";
    }
    
    
    
    /**
     * to about
     * 
     * @return
     */
    @RequestMapping("/about.htm")
    public String about() {

        return "about/about";

    }
    
}
