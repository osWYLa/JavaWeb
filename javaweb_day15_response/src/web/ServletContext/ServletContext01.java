package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description
 * @Version
 */
@WebServlet("/servletContext01")
public class ServletContext01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象的获取
            //1.通过request对象获取
        ServletContext servletContext = req.getServletContext();
        //2.通过HttpServlet对象获取
        ServletContext servletContext1 = this.getServletContext();

        System.out.println(servletContext == servletContext1); //true

        //定义文件名称
        String filename = "a.jpg";

        //获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);

    }
}
