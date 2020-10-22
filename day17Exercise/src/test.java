import edu.dao.UserDao;
import edu.dao.impl.UserDaoImpl;
import edu.domain.User;
import edu.service.impl.UserServiceImpl;
import edu.util.JDBCUtils;
import org.junit.Test;


/**
 * @author wyl
 * @create 2020-10-21
 * @Description
 * @Version
 */
public class test {
        @Test
        public void testLogin() {
            //建立测试查询对象
            User loginUser = new User();
            loginUser.setUsername("yuye");
            loginUser.setPassword("123");

            UserDao userDao = new UserDaoImpl();
            UserServiceImpl userService = new UserServiceImpl();

            User user = userService.login(loginUser);

            System.out.println(user);
        }
    }
