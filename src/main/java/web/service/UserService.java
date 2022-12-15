package web.service;

import web.model.User;
import java.util.List;

interface UserService {
    List<User> getAllUsers ();
    Object getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}
