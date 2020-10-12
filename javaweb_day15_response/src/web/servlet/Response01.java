package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-09
 * @Description
 * @Version
 */
@WebServlet("/response01")
public class Response01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response01 ...");
        /*//重定向
            //设置状态码为302
        resp.setStatus(302);
        resp.setHeader("location","/response02");*/

        //重定向的简单方法

        //resp.sendRedirect("location","/response02");

        //可重定向至其他站点
        resp.sendRedirect("https://www.baidu.com");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
