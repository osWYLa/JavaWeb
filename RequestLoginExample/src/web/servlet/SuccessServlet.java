package web.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description
 * @Version
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取域中共享的对象
        User user = (User) req.getAttribute("user");

        if (user != null){
            resp.setContentType("text/html;charset=utf-8");

            resp.getWriter().write("登录成功-"+user.getUsername()+"欢迎您！");
        }
    }
}
