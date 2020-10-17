package cn.VerifyCheckCodeServlet.web;

import cn.VerifyCheckCodeServlet.Dao.UserDao;
import cn.VerifyCheckCodeServlet.domain.User;
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
 * @create 2020-10-16
 * @Description
 * @Version
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("loginServlet");
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //参数获取
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //parameterMap.remove("checkCode");/////报错

        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        User loginUser = new User();

        if (checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){
            try {
                BeanUtils.populate(loginUser,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);

            if (user == null){
                request.getRequestDispatcher("/failServlet").forward(request,response);
            }else {
                request.setAttribute("user",user);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }
        } else {
            //验证码不一致
            request.setAttribute("cc_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
