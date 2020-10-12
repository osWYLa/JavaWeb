package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description 获取文件真实运行路径
 * @Version
 */
@WebServlet("/servletContext04")
public class ServletContext04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象的获取
        ServletContext servletContext = req.getServletContext();

        //获取文件真实路径
            //1.获取web目录下的b.txt
        String b = servletContext.getRealPath("/b.txt");
        System.out.println("b:"+b);
       //
            //2.获取web-->WEB-INF目录下的c.txt
        String c = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println("c"+c);
            //3.获取src下的a.txt 。最后发布时，src中的内容会被发布到 WEB-INF的classes目录下
            //注意：src目录下的资源访问路径，还可以通过ClassLoader获取，但是ClassLoader只能获取src目录下的资源，并不能获取web目录下的资源。局限较大

        String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println("a"+a);

    }
}
