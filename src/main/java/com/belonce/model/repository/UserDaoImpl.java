package com.belonce.model.repository;

import com.belonce.model.entity.User;
import com.belonce.model.irepository.UserDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {


    private SessionFactory sessionFactory;
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//    private SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//    Session session;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public User createUser(User user) {

        currentSession().save(user);
        return user;
    }

    public void updateUser(User user) {

        currentSession().update(user);
    }

    public void deleteUser(User user) {

        currentSession().delete(user);

    }

    public User getUserById (long id)
    {
        return (User) currentSession().get(User.class, id);
    }
}
