import com.zrrd.dao.CityDao;
import com.zrrd.dao.UserDao;
import com.zrrd.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        UserDao userDao =(UserDao) ac.getBean("userDao");
//        userDao.save("zhang3");
//
//        CityDao cityDao =(CityDao) ac.getBean("CityDao");
//        cityDao.delete(99);
        UserService userService =(UserService) ac.getBean("userService");
        userService.save("zhang3");
    }

}
