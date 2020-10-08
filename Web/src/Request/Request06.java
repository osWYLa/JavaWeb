package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author wyl
 * @create 2020-10-08
 * @Description request获取请求体数据（只有POST有请求体）
 * @Version
 */

@WebServlet("/Request06")
public class Request06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通用方法获取GET请求参数
        /*String username = req.getParameter("username"); //方法不区分请求方式，通用
        System.out.println("get---"+username);*/
        this.doPost(req,resp);
        //代码只写一份，下面调用即可（业务逻辑实现一次即可）
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通用方法获取POST请求参数
        //根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("post---"+username);
        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby:hobbies){
            System.out.println(hobby);
        }
        //获取所有请求参数的名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name); //只能获取一个，对于复选框之类的需要通过数组接收。这里对于有两个的只能接受一个
            System.out.println(value);
        }
        System.out.println("=======================");
        //获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.print(name);
            String[] values = parameterMap.get(name);
            for (String value:values
                 ) {
                System.out.println(value);
            }
        }

    }
}
