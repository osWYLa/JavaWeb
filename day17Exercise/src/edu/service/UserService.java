package edu.service;

import edu.domain.PageBean;
import edu.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author wyl
 * @create 2020-10-19
 * @Description 用户管理业务接口
 * @Version
 */
public interface UserService {
    public List<User> findAll();
    User login(User user);
    void addUser(User user);
    void deleteUserById(String id);
    void deleteUsersByUids(String[] uids);


    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
