package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author wyl
 * @create 2020-10-12
 * @Description
 * @Version
 */
@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
     * @Author wyl
     * @function
     * @Param [request, response]
     * @return void
     */
        response.setContentType("text/html;charset=utf-8");
        //创建Cookie对象(可以创建和发送多个Cookie)
        Cookie cookie = new Cookie("msg", URLEncoder.encode("你好a","UTF-8"));//8之后允许存中文，
        Cookie cookie1 = new Cookie("name", "yuye");

            //设置Cookie存活时间
        cookie.setMaxAge(30);  //30s后msg中的信息自动删除（正数）
        //发送Cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
