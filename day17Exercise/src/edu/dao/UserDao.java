package edu.dao;

import edu.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author wyl
 * @create 2020-10-20
 * @Description 用户操作的DAO
 * @Version
 */
public interface UserDao {
    public List<User> findAll();
    User findUserByUsernameAndPassword(String username,String password);
    void add(User user);

    void deleteUserById(int id);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
