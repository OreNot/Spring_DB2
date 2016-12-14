package com.belonce.model.repository;

import com.belonce.model.entity.User;
import com.belonce.model.irepository.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }
}
