package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-09-28
 * @Description 使用注解配置，不再使用xml文件配置
 * @Version
 */
@WebServlet(urlPatterns = "/annotationServlet")
public class AnnotationServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("annotation servlet init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("annotation servlet service...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("annotation servlet destroy...");
    }
}
