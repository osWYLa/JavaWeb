package edu.web.servlet;

import edu.domain.PageBean;
import edu.domain.User;
import edu.service.UserService;
import edu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author wyl
 * @create 2020-10-21
 * @Description
 * @Version
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");

        //健壮性判断
        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition  = request.getParameterMap();




        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(currentPage,rows,condition);

        //后台校验，防止请求的页码超出最大页码数（有个小bug，需要在前端设置访问页码受限）
        /*if (pageBean.getCurrentPage() > pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
            //return;
        }*/
        pageBean.setCurrentPage(pageBean.getCurrentPage() >= pageBean.getTotalPage() ? pageBean.getTotalPage() : pageBean.getCurrentPage());


        //System.out.println(pageBean); //测试后台代码是否可行

        //回写查询数据
        request.setAttribute("condition",condition);//将查询数据一起存入request,一起转发到Jsp中

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
