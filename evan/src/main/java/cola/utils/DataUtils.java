package cola.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataUtils {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
