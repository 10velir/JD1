package services;

import entities.User;

/**
 * Class UserService
 *
 * Created by yslabko on 08/11/2017.
 */
public interface UserService {

    User getByLogin(String login);
}
