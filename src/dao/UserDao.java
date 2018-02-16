package dao;

import java.sql.SQLException;

import entities.User;

/**
 * Class UserDao
 *
 * Created by yslabko on 08/11/2017.
 */
public interface UserDao extends DAO<User> {
    User getByLogin(String login) throws SQLException;
}
