package cola.service;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Transactional(propagation = Propagation.REQUIRED)
    public void test() {

        jdbcTemplate.update(" insert into  users(user_name) values ('evan')");
        System.out.println(1 / 0);// 2
        jdbcTemplate.update(" insert into  users(user_name) values ('evan')");
    }

}
