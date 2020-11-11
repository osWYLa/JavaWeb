package edu.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author wyl
 * @create 2020-10-23
 * @Description
 * @Version
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /*
     * @Author wyl
     * @function 监听ServletContext对象创建。ServletContext对象在服务器启动后自动创建 。init 在 服务器启动之后自动调用（需要在xml或者注解中注册监听）
     * @Param
     * @return
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //加载资源文件
        //1. 获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");  /* 通过web.xml配置监听器和初始化参数,这里配置的初始化参数在使用注解配置的时候依然有用*/
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        System.out.println(realPath);
        //4.加载进内存

        try {
            FileInputStream fileInputStream = new FileInputStream(realPath);
            System.out.println(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("listener init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener destroy...");
    }
}
