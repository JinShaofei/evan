package cola.service;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService implements Runnable {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    private void test() {

        // jdbcTemplate.execute(" insert into users(user_name) values
        // ('evan')");
        // System.out.println(1 / 0);// 2
        // jdbcTemplate.execute(" insert into users(user_name) values
        // ('evan')");
        while (this.jdbcTemplate.queryForObject("select count(id) from users where user_state = 0 ",
                Integer.class) > 0) {
            Integer id = this.jdbcTemplate.queryForObject("select id from users where user_state = 0 limit 1",
                    Integer.class);
            if (id > 0) {
                String name = Thread.currentThread().getName();
                System.out.println("执行线程" + name);
                this.jdbcTemplate.execute(
                        "update users set user_name = '" + name + "',user_balance=100,user_state =1 where id = " + id);
            }
        }
    }

    @Override
    public void run() {
        test();

    }

    public void insert() {
        for (int i = 0; i < 1000; i++) {
        jdbcTemplate.execute(" insert into users(user_name,user_state) values('evan',0)");
        }
    }

    public int queryBalance() {
        int amount = 0;

        try {
            amount = this.jdbcTemplate.queryForObject("select sum(user_balance) from users where user_state = 1 ",
                    Integer.class);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return amount;
    }

    public void normal() {
        while (this.jdbcTemplate.queryForObject("select count(id) from users where user_state = 0 ",
                Integer.class) > 0) {
            Integer id = this.jdbcTemplate.queryForObject("select id from users where user_state = 0 limit 1",
                    Integer.class);
            if (id > 0) {
                String name = Thread.currentThread().getName();
                System.out.println("执行线程" + name);
                this.jdbcTemplate.execute(
                        "update users set user_name = '" + name + "',user_balance=100,user_state =1 where id = " + id);
            }
        }

    }

}
