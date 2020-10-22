package edu.dao.impl;

import edu.dao.UserDao;
import edu.domain.User;
import edu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wyl
 * @create 2020-10-20
 * @Description
 * @Version
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {
        try {
            //使用JDBC操作数据库
            //1.定义sql
            String sql = "select * from user";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;

        } catch (DataAccessException e) {
            e.printStackTrace();//日志
            return null;
        }
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,'test','123') "; //由于add.jsp中并没有写username和password模拟一下。
                                                                                // 同时，这里的用户表单和管理表单并没有分开
        //set names gbk;
        //执行sql
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();
        // value 和 ？对应
        List<Object> params = new ArrayList<>();

        for (String key :
                keySet) {

            //排除currentPage和rows 参数的影响
            if ("currentPage".equals(key) ||"rows".equals(key)){
                continue;
            }

            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");//注意空格
                //保存？的值,后面调用sql查询时传参
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString()); //一定要注意更新sql语句
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray()); //返回Integer自动拆箱成int
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();
        // value 和 ？对应
        List<Object> params = new ArrayList<>();

        for (String key :
                keySet) {

            //排除currentPage和rows 参数的影响
            if ("currentPage".equals(key) ||"rows".equals(key)){
                continue;
            }

            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");//注意空格
                //保存？的值,后面调用sql查询时传参
                params.add("%"+value+"%");
            }
        }

        //分页查询
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        //这里的params参数还有用么？
        //更新sql 并查询
        /*sql = sb.toString();*/
        System.out.println(sb.toString()); //一定要注意更新sql语句
        System.out.println(params);
        return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
