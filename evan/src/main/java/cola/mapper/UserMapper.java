package cola.mapper;

import cola.annotation.DataSource;
import cola.entity.User;

/**
 * 
 * @author shaofeijin
 *
 */
public interface UserMapper {

    /**
     * save user
     */
    @DataSource("master")
    void save(User u);

    /**
     * list user
     */
    @DataSource("slave")
    void list();

}
