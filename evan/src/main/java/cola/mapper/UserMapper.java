package cola.mapper;

import org.apache.ibatis.annotations.Param;

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

    @DataSource("master")
    User getUserByMobilePass(@Param("userMobile") String userMobile, @Param("passWord") String passWord);

}
