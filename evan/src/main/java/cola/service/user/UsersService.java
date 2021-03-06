package cola.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cola.entity.User;
import cola.mapper.UserMapper;

/**
 * 
 * @author shaofeijin
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UsersService {

    // usermapper
    @Autowired
    private UserMapper userMapper;

    public void saveUser(User u) {
        this.userMapper.save(u);
    }

    public User getUserByMobilePass(String userMobile, String passWord) {
        return userMapper.getUserByMobilePass(userMobile, passWord);
    }

}
