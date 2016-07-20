package cola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cola.service.TestService;

@Controller
public class TestController {

    @Autowired
    private TestService sss;

    @RequestMapping("/test.htm")
    public String test() {

        System.out.println("sdkfslfjsdfsjdlfjs");

        this.sss.test();

        return "test";

    }

    public static void main(String[] args) {

        System.out.println("xxxxxxxxx");
    }

    public static int t(int n) {

        if (n <= 1) {
            return 1;
        } else {
            return n * t(n - 1);
        }
    }

}
