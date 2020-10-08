package Dao;

import domain.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description 操作数据库中的User表的类
 * @Version
 */

public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /*
     *@param loginUser 只有用户名和密码
     * @return user 对象，包含用户全部数据，如果没有查询到，返回null值，以作判断
     *
     * */
    public User login(User loginUser) {
        //sql
        String sql = "select * from user where username = ? and password = ?";
        //调用query方法
        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
