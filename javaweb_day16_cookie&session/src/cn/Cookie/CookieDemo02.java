package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-12
 * @Description
 * @Version
 */
@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //获取Cookie
        Cookie[] cookies = request.getCookies();
        //获取数据，遍历
        if (cookies !=null){
            for (Cookie c :
                    cookies) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name+": "+value);
                response.getWriter().write("欢迎，"+name+": "+value);
                System.out.println("zhongwen中文");
            }
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
