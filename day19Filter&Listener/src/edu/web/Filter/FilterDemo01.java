package edu.web.Filter;

import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-22
 * @Description
 * @Version
 */

/*配置拦截路径*/
/*@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)*/
@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("filter01  ...");

        //转发
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filter01回来了 ...");

    }

    @Override
    public void destroy() {
        System.out.println("filter destroy...");

    }
}
