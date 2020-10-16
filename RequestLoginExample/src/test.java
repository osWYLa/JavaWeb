import Dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description
 * @Version
 */
public class test {
    @Test
    public void testLogin(){
        //建立测试查询对象
        User loginUser = new User();
        loginUser.setUsername("yuye");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        System.out.println(user);
    }
}
