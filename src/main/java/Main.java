import com.belonce.model.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String ...args)
    {
        System.out.println("Hello!");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        User user1 = (User) context.getBean("user1");
        System.out.println(user1.getFirstName());
    }
}
