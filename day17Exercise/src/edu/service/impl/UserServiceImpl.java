package edu.service.impl;

import edu.dao.UserDao;
import edu.dao.impl.UserDaoImpl;
import edu.domain.PageBean;
import edu.domain.User;
import edu.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author wyl
 * @create 2020-10-19
 * @Description
 * @Version
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();//使用接口接受，向上转型，便于维护

    @Override
    public List<User> findAll() {
        //调用Dao完成查询，返回结果

        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getName(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUserById(String id) {
        dao.deleteUserById(Integer.parseInt(id));
    }

    @Override
    public void deleteUsersByUids(String[] uids) {

        if (uids != null && uids.length > 0) {
            //遍历id
            for (String uid :
                    uids) {
                //删除
                deleteUserById(uid);
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);


        //防止页数为负数
        if (currentPage <= 0){
            currentPage = 1;
        }


        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        //这里需要添加传参
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //这里需要添加传参
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pageBean.setList(list);

        int totalPage = (totalCount % rows) == 0 ? totalCount/rows :(totalCount / rows) + 1;
        pageBean.setTotalPage(totalPage);


        return pageBean;

    }
}
