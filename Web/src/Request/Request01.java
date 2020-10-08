package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description request获取请求行数据
 * @Version
 */
@WebServlet("/Request01")
public class Request01 extends HttpServlet {
    //GET方式看doGet方法
        //http://localhost:8080/Request/Request01?name=zhangsan&age=12
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式：GET
        String method = req.getMethod();
        System.out.println(method);
        //2.获取虚拟目录：/Request
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet路径：/Request01
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //4.获取get方式请求参数：name = zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //5.获取请求的URL  /Request/Request01     http://localhost:8080/Request/Request01
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //6.获取协议及版本：HTTP /1.1
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //7.获取客户机IP  0:0:0:0:0:0:0:1
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);

    }

    //POST看doPOST方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
