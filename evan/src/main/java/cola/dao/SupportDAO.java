package cola.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author shaofeijin
 *
 */
@Repository
public class SupportDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public String test() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id ,user_name from users");
        jdbcTemplate.update(" insert into  users(user_name) values ('evan')");

        return null;
    }


}
