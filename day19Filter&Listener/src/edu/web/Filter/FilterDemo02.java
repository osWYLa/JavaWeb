package edu.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-23
 * @Description
 * @Version
 */
@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo02 implements Filter {
    public void destroy() {
        System.out.println("filter demo02 destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter02 ...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter demo02 init");
    }

}
