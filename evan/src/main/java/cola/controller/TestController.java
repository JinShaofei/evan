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

        // this.sss.test();
        // this.sss.run();
        Long begin = System.currentTimeMillis();
        System.out.println("主线程开始======");
        Thread t1 = new Thread(this.sss);
        t1.start();

        Thread t2 = new Thread(this.sss);
        t2.start();

        Thread t3 = new Thread(this.sss);
        t3.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.sss.normal();
        int amount = this.sss.queryBalance();
        System.out.println("获取所有用户余额" + amount);

        Long end = System.currentTimeMillis();
        System.out.println("主线程结束======用时" + new Long(end - begin));
        return "test";


    }

    @RequestMapping("/insert.htm")
    public String insert() {

        this.sss.insert();
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
