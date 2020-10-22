package edu.web.servlet;

import edu.service.UserService;
import edu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-21
 * @Description
 * @Version
 */
@WebServlet("/delSelectedCheckBoxsServlet")
public class DelSelectedCheckBoxsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取所有选中的复选框的对应id
        String[] uids = request.getParameterValues("uid");
        UserService service = new UserServiceImpl();

        service.deleteUsersByUids(uids);

        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
