package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description request获取请求头数据，获取User-agent信息
 * @Version
 */
//http://localhost:8080/Request/Request03?name=zhangsan&age=12
@WebServlet("/Request03")
public class Request03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取User-agent头信息
        String agent = req.getHeader("user-agent"); //不区分大小写
        //判断浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("谷歌。。。");
        }else if(agent.contains("Firefox")){
            System.out.println("火狐。。。");
        }else{
            System.out.println("其他浏览器。。。");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
