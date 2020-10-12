package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description  //服务器输出字符输出流
 * @Version
 */
@WebServlet("/response03")
public class Response03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码格式
            //方式1：resp.setCharacterEncoding("GBK");
            //方式2：resp.setHeader("Content-Type","text/html;charset=utf-8");
            //方式3:(推荐使用)
            resp.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>hello你好啊<h1>");  //可以输出普通文本，也可以携带HTML标签，浏览器会自动解析



    }
}
