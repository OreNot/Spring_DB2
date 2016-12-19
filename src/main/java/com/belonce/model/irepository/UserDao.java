package com.belonce.model.irepository;

import com.belonce.model.entity.User;

public interface UserDao {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserById(long id);
}
