package edu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-23
 * @Description 先 登录， 后直接 访问 http://localhost/day17Exercise/testSensitiveWordsServlet?name=zhangsan&msg=%E5%9D%8F%E8%9B%8B%E6%95%8F%E6%84%9F%E8%AF%8D%E6%B1%87
 *              http://localhost/day17Exercise/testSensitiveWordsServlet?name=zhangsan&msg=坏蛋敏感词汇
 *                              用以测试 敏感词汇 过滤
 * @Version
 */
@WebServlet("/testSensitiveWordsServlet")
public class TestSensitiveWordsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String msg = request.getParameter("msg");

        System.out.println(name+":"+msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
