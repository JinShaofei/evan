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


    @Autowired
    private UserMapper userMapper;

    public void addUser() throws Exception {

            for (int i = 0; i < 3; i++) {
                User u = new User();
                u.setUserName("obama");
                u.setUserBalance(100);
                u.setUserState(1);
                this.userMapper.save(u);

            }

    }

}
