package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description request获取请求体数据（只有POST有请求体）
 * @Version
 */
//http://localhost:8080/Request/Request03?name=zhangsan&age=12
@WebServlet("/Request05")
public class Request05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求消息体（本质上还是通过流获取数据，这里需要注意，POST  需要设置字符集，防止中文乱码）
        //获取字符流
        BufferedReader reader = req.getReader();
        //读取数据
        String line = null;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
        //流暂时不用关闭，因为流通过request获取出来的
    }
}
