package cn.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-17
 * @Description
 * @Version
 */
@WebServlet("/sessionServlet03")
public class SessionServlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);

        //期望客户端关闭后，session 也可以相同（默认情况下基本不会相同的）
        //创建Cookie，设置同名键
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
