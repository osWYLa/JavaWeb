package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description 浏览器输出字节数据
 * @Version
 */
@WebServlet("/response04")
public class Response04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("你好啊".getBytes("utf-8")); //getBytes默认GBK编码？
    }
}
