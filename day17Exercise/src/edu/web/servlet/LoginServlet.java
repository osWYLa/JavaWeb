package edu.web.servlet;

import edu.domain.User;
import edu.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author wyl
 * @create 2020-10-21
 * @Description
 * @Version
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取(用户填写)验证码，进行校验
        String verifycode = request.getParameter("verifycode");
       // System.out.println(verifycode);
        //获取正确的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
       // System.out.println(checkcode_server);
        //确保验证码一致性
        session.removeAttribute("CHECKCODE_SERVER");

        //校验
        if (!(checkcode_server.equalsIgnoreCase(verifycode))){
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //直接return掉，后面就不执行了
            return;
        }


        Map<String, String[]> map = request.getParameterMap();
        //需要注意的是，获取map集合数据时，注意检查login.jsp 页面提交的数据名，防止数据名错误引发的查询错误
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //service查询
        UserServiceImpl service = new UserServiceImpl();
        User loginUser = service.login(user);

        //System.out.println(loginUser.toString());

        //登录用户VS数据库查询结果
        if (loginUser != null){
            session.setAttribute("user",loginUser);//有些不符合习惯
            //跳转
            response.sendRedirect(request.getContextPath()+"/index.jsp");//没有共享数据，直接使用重定向（加上动态虚拟目录）                 //① 注意对比目录
        }else {
            //登录失败
            request.setAttribute("login_msg","用户名或密码错误，请重新登录");
            //跳转
            request.getRequestDispatcher("/login.jsp").forward(request,response);         //②
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
