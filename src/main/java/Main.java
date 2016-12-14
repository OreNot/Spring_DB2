import com.belonce.model.entity.User;
import com.belonce.model.repository.UserDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Autowired
    static UserDaoImpl userDaoImpl;

    public static void main(String ...args)
    {
        System.out.println("Hello!");
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

       // SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        //User user1 = (User) context.getBean("user1");

//        Session session;
//
//        try {
//            session = sessionFactory.getCurrentSession();
//        }
//        catch (HibernateException e)
//        {
//            session = sessionFactory.openSession();
//        }

        User user1 = new User();
        user1.setFirstName("Petr");
        user1.setEmail("petr@mail.ru");
        user1.setLastName("Petrov");
        user1.setLogin("petya");
        user1.setPassword("pts2");

        userDaoImpl.createUser(user1);
        //userDaoImpl.createUser(user1);



        System.out.println(user1.getFirstName());
    }
}
