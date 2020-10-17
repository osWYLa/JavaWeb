package cn.VerifyCheckCodeServlet.Dao;

import cn.VerifyCheckCodeServlet.domain.User;
import cn.VerifyCheckCodeServlet.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author wyl
 * @create 2020-10-16
 * @Description
 * @Version
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

   public User login(User loginUser){
       try {
           String sql = "select * from user where username = ? and password = ?";
           User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
           return user;
       } catch (DataAccessException e) {
           e.printStackTrace();//日志打印
           return null;
       }
   }
}
