import com.belonce.model.entity.User;
import com.belonce.model.irepository.UserDao;
import com.belonce.model.repository.UserDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    @Autowired
    static UserDao userDao;

    public static void main(String ...args)
    {
        System.out.println("Hello!");
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        //User user1 = (User) context.getBean("user1");



       // Session session;

//        try {
//            session = sessionFactory.getCurrentSession();
//        }
//        catch (HibernateException e)
//        {
//            session = sessionFactory.openSession();
//        }

        User user1 = new User();
        user1.setFirstName("Alexandrs");
        user1.setEmail("alexs@mail.ru");
        user1.setLastName("Alexandrovichs");
        user1.setLogin("alexs");
        user1.setPassword("al2");

       // UserDaoImpl userDao = new UserDaoImpl();
        userDao.createUser(user1);

        //session.save(user1);
//
       // System.out.println(user1.getFirstName());

//        try {
//            ServerSocket serverSocket = new ServerSocket(8080);
//
//            while (true)
//            {
//                Socket socket = serverSocket.accept();
//                System.out.printf("accepted");
//
//
//                InputStream inputStream = socket.getInputStream();
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//
//                String message = in.readLine();
//                System.out.println(message);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
