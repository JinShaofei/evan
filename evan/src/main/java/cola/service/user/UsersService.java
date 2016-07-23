package cola.service.user;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cola.dao.UserDao;

/**
 * 
 * @author shaofeijin
 *
 */
@Service
public class UsersService {


    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser() throws SQLException {

        for (int i = 0; i < 3; i++) {
            this.userDao.save();
            int j = 1 / 0;
        }

    }

}
