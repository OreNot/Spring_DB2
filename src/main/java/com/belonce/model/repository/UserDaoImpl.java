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

    //@Autowired
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    private SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    Session session;

    public User createUser(User user) {
        try {
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e)
        {
            session = sessionFactory.openSession();
        }
        session.save(user);
        //sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }
}
