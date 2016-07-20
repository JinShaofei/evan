package cola;

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
        jdbcTemplate.update("update users set user_name = 'obama' where id = 1");
        int i = 100 / 0;
        System.out.println(list);

        return null;
    }


}
