package cola.controller.logic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toDogView() {
        return "logic/dog";
    }

    /**
     * to dog view
     * 
     * @return
     */
    @RequestMapping("/toCat.htm")
    public String toCatView() {
        return "logic/cat";
    }

    /**
     * toOthers
     * 
     * @return
     */
    @RequestMapping("/toOthers.htm")
    public String toOthers() {
        return "logic/others";
    }


}
