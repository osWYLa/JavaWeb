package Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-09-28
 * @Description
 * @Version
 */
public class ServletDemo1 implements Servlet {

    /*
    servlet生命周期:
    1.创建：执行init方法，执行一次
        * servlet什么时候被创建？
            - 默认情况下，第一次被访问的时候，servlet被创建；
            - 可以通过配置指定servlet的创建时机
        * servlet的init方法只执行一次，说明一个servlet在内存中只存在一个对象（servlet是单例的）
          问题： 多用户访问时，可能存在线程安全问题；
          方案：加锁（效率太低，不使用）；尽量不在servlet中定义成员变量（要使用去方法里面定义局部变量使用）；即使定义了成员变量也不要对其修改；
    2.提供服务:执行service方法，可执行多次
    3.销毁：执行destroy方法，执行一次
    * */

    /*
    * 初始化方法：在servlet被创建时执行，只会执行一次；
    * （实现servlet接口的对象在第一次调用时通过反射创建，创建之后执行init方法）
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /*
    * 用于获取servletConfig对象，配置对象用于配置servlet
    * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法:每次servlet被访问时就会被执行（可以执行多次）
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    /*
    * 获取servlet信息
    * */
    @Override
    public String getServletInfo() {
        return null;
    }
    //销毁方法，servlet被销毁时（在服务器正常关闭时执行）执行一次
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
