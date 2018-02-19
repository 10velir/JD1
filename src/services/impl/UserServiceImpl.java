package services.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import services.ServiceException;
import services.UserService;

import java.sql.SQLException;

/**
 * Class UserServiceImpl
 *
 * Created by yslabko on 08/11/2017.
 */
public class UserServiceImpl extends AbstractService implements UserService {
    private static volatile UserService INSTANCE = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public User getByLogin(String login) {
        try {
            return userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login" + login);
        }
    }

    @Override
    public User createUser(User user) {

        try {
            user = userDao.createUser(user);
        } catch (SQLException e) {
            throw new ServiceException("smth wrong");
        }

        return user;
    }

    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }

        return userService;
    }
}
