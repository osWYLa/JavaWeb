package edu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-23
 * @Description
 * @Version
 */
@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换，获取URI路径
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        System.out.println(uri);
        //筛选资源，放行登录相关资源，防止死循环和资源不显
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet"))
        //注意checkCodeServlet后面不要带/
        {
            //登录相关资源不拦截直接放行
            chain.doFilter(req,resp);
        }else{
            //其他页面，验证用户是否已经登录
            //loginServlet中，登录成功后会在session中放入user 这个键，这里可以用作判断
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //已经登录，直接放行
                chain.doFilter(req,resp);
            }else {
                //没有登录，跳转登录页面
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }



        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
