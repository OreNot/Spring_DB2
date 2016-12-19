import com.belonce.model.entity.User;
import com.belonce.model.irepository.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

//    @Autowired
//    static UserDao userDao;

    public static void main(String ...args)
    {
        System.out.println("Hello!");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserDao userDao = (UserDao) context.getBean("userDao");
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
        user1.setFirstName("Vadim");
        user1.setEmail("vadim@mail.ru");
        user1.setLastName("Vladimirovich");
        user1.setLogin("Vadim");
        user1.setPassword("vd2");


        //userDao.createUser(user1);
        //userDao.deleteUser(user1);
        //userDao.updateUser(user1);




       // userDao.createUser(user1);

        //session.save(user1);
//
       // System.out.println(user1.getFirstName());

//        Runnable runnable = new Runnable() { //Клиент для сервера -----
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//
//                    Socket client = new Socket("localhost", 8080);
//                    OutputStream outputStream = client.getOutputStream();
//                    PrintWriter out = new PrintWriter(outputStream, true);
//                    out.println("Hi!");
//                    out.flush();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread thread1 = new Thread(runnable);
        //thread1.start(); //-----

        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("accepted");


                InputStream inputStream = socket.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                String message = in.readLine();
                String[] operation = message.split(" ");

                User user2 = new User();
                user2.setFirstName(operation[1]);
                user2.setEmail(operation[2]);
                user2.setLastName(operation[3]);
                user2.setLogin(operation[4]);
                user2.setPassword(operation[5]);

                switch (operation[0])
                {
                    case "save" : userDao.createUser(user2);
                        break;

                    case "delete" : userDao.deleteUser(user2);
                        break;
//
//                    case "update" : session.update(user2);
//                        break;
                }
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
