package cn.CookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wyl
 * @create 2020-10-16
 * @Description
 * @Version
 */
@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");

        //判断Cookie中是否含有lastTime键，标志
        boolean flag = false;

        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length > 0){
            for (Cookie c :
                    cookies) {
                String name = c.getName();
                if ("lastTime".equals(name)){
                    flag =true;

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);
                    //编码 特殊字符（空格）
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后："+str_date);
                    //设置lastTime值为新的时间
                    c.setValue(str_date);
                    //设置cookie存活时间为一个月
                    c.setMaxAge(60*60*24*30);
                    //更新cookie（包含新时间）
                    response.addCookie(c);
                    //获取老cookie中的数据，键为lastTime的value
                    String value = c.getValue();
                    //URL解码：
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);

                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为: "+value+"</h1>");
                    System.out.println("中国字测试");
                    break;

                }
            }
        }
        if(cookies == null || cookies.length ==0 || flag==false){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");

            String str_date = simpleDateFormat.format(date);

            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime", str_date);



            cookie.setMaxAge(60*60*24*30);


            response.addCookie(cookie);

            //URL解码：
            str_date = URLDecoder.decode(str_date,"utf-8");
            System.out.println("解码后："+str_date);

            response.getWriter().write("<h1>您好，这是首次访问，访问时间："+str_date+"</h1>");
            System.out.println("中国字");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
