package edu.web.filter;

import edu.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author wyl
 * @create 2020-10-23
 * @Description
 * @Version
 */
@WebFilter(value = "/*")
public class SensitiveWordsFilter implements Filter {

    //建立list集合用于存放敏感词汇
    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        try {
            //读取敏感词汇集合
            //获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");//src 目录下的路径写法
            System.out.println(realPath);
            //读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath)); //这里使用流读入的时候默认GBK？需要注意，但是文件设置为UTF-8也读取了
            //读取每行至list
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    String value = (String) method.invoke(req, args);
                    if (value!=null){
                        for (String str :
                                list) {
                            if (value.contains(str)){
                                value = value.replace(str,"***");
                            }
                        }
                    }
                    return value;
                }


                return method.invoke(req, args);

            }
        });

        //放行，注意替换成proxy_req
        chain.doFilter(proxy_req, resp);
    }


}
