package entities;

import lombok.Data;

/**
 * Class User
 *
 * Created by yslabko on 08/11/2017.
 */
@Data
public class User {
    private long id;
    String name;
    String login;
    String password;
    String status;
    String role;
}
