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
 * @Description request获取请求头数据，获取referer信息
 * @Version
 */
//http://localhost:8080/Request/Request04?name=zhangsan&age=12
@WebServlet("/Request04")
public class Request04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取User-agent头信息
        String referer = req.getHeader("referer"); //直接浏览器访问返回null，通过超链接点击跳转查看
        System.out.println(referer);
        if (referer !=null){
            if (referer.contains("/Request")){
                //含有正常的信息,正常访问
                System.out.println("正常访问。。。");

                //显示中文需要设置
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("正常访问。。。");

            }else {
                System.out.println("请跳转至。。。");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("请跳转至。。。");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
