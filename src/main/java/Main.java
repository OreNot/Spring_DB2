import com.belonce.model.entity.User;
import com.belonce.model.irepository.UserDao;
import com.belonce.model.repository.UserDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Autowired
    static
    SessionFactory sessionFactory;

    public static void main(String ...args)
    {
        System.out.println("Hello!");
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //User user1 = (User) context.getBean("user1");

        User user1 = new User();
        user1.setFirstName("Vasya");
        user1.setEmail("vasya@mail.ru");
        user1.setLastName("Ivanov");
        user1.setLogin("vasya");
        user1.setPassword("vs12");

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.createUser(user1);



        System.out.println(user1.getFirstName());
    }
}
