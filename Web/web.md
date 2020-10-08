# WEB

## WEB相关概念

1. 软件架构
   - C/S
   - B/S
   
2. 资源分类
  
   ![资源分类](web.assets/资源分类.bmp)
   
   - 静态资源
   - 动态资源（动态资源先转化成静态资源再返回给浏览器）
   
3. 网络通信三要素
   - IP
   - 端口
   - 传输协议

## WEB服务器软件

* 服务器：安装了服务器软件的计算机

* 服务器软件：接收用户的请求，处理请求，做出响应

* web服务器软件：接收用户的请求，处理请求，做出响应
	* 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
	* web容器
	
* 常见的java相关的web服务器软件：

  * webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的

  * webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的

  * JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的

  * Tomcat：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的

- JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范

- Tomcat：web服务器软件

  1. 下载：http://tomcat.apache.org/

  2. 安装：解压压缩包即可（安装目录建议不要有中文和空格）

  3. 卸载：删除目录

  4. 启动

     1. bin/startup.bat ,双击运行该文件即可

     2. 访问：浏览器输入：http://localhost:8080 回车访问自己； http://别人的ip:8080 访问别人

        > 可能会遇到的问题：
        >
        > 1. 黑窗口一闪而过：
        >    * 原因： 没有正确配置JAVA_HOME环境变量
        >    * 解决方案：正确配置JAVA_HOME环境变量
        >    
        > 2. 启动报错：（查看日志）端口占用
        >
        >    1. 暴力：找到占用的端口号，并且找到对应的进程，杀死该进程（管理员运行CMD)
        >
        >       ```java
        >       netstat -ano|findstr 8080  //查看8080端口占用进程
        >       taskkill -pid 刚才查到的pid -f  //不加f会通知OS结束线程，加f强制结束
        >       ```
        >
        >    2. 温柔：修改自身端口号（不推荐使用）
        >
        >       - 打开tomcat安装目录下的配置文件：conf/server.xml
        >
        >       - 设置
        >
        >         ```xml
        >         <Connector port="8080" protocol="HTTP/1.1"
        >         		               connectionTimeout="20000"
        >         		               redirectPort="8445" />
        >         ```
        >
        >       - 一般会将tomcat的默认端口号修改为80端口，80端口是HTTP协议默认端口。好处就是，在访问时可以不用输入端口号即可访问

  5. 关闭

     1. 正常关闭
        - bin/shutdown.bat
        - ctrl+c
     2. 强制关闭
        - 直接关闭tomcat窗口

  6. 配置（介绍三种在tomcat下部署项目的方式）

     1. 直接将项目放到webapps目录下

        - /hello :项目的访问路径-->虚拟目录
        - 这种方式可以简化一下：将整个项目打包成一个war包，再将war包放置在webapps目录下。（war包将会自动解压缩，同时删除war包，解压缩的文件夹自动会删除）

     2. 配置conf/server.xml文件（配置错误有可能影响其他的程序，不推荐使用）

        在<host>标签体中配置：

        ```xml
        <Context docBase="D:\hello" path="/hehe" />
        //其中
        docBase：项目存放的路径
        path:虚拟目录
        ```

     3. 在conf\Catalina\localhost创建任意名称的xml文件

        在新建的xml文件中写配置：

        ```xml
        <Context docBase="D:\hello" />
        虚拟目录的名称时：xml文件的名称
        ```

- 动态项目的目录结构（对比静态项目的目录结构）

  - 项目根目录
    
    ![tomcat目录结构](web.assets/tomcat目录结构.png)
    
    - WEB-INF目录
      - web.xml :web 项目的核心配置文件
      - classes目录：放置字节码文件的目录
      - lib目录：放置依赖jar包

## IDEA中继承tomcat，创建JavaEE项目，部署项目

> 问题及解决方案：
>
> 1. tomcat log 中文乱码问题；
>
>    - 调整tomcat安装目录下conf/logging.properties中所有encoding为UTF-8
>
>    - IDEA中设置所有编码为UTF-8；help-->Edit Custom VM options，添加：
>
>      `-Dfile.encoding=UTF-8`
>
> 2. Tomcat设置
>
>    - run-->Confriguations-->server-->"Update resources"
>
>      ​											-->Deployment-->Application context:/ 设置虚拟目录
>    
> 3. IDEA会为每一个tomcat部署的项目单独建立一份配置文件，具体配置文件的位置可以通过查看控制台中log获取:
>
>    ​	`Using CATALINA_BASE:   "C:\Users\18395\AppData\Local\JetBrains\IntelliJIdea2020.1\tomcat\Tomcat_8_5_58_JavaWeb"`
>
> 4. 需要区分工作空间目录 和  tomcat部署的web项目 目录
>
>    - tomcat真正访问的是“tomcat部署的web项目”，"tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
>    - WEB-INF目录下的资源不能被浏览器直接访问
>
> 5. 断点调试

## Servlet入门

- 概念：运行在服务器端的小程序
  - Servlet是一个接口，定义了Java类被浏览器访问到（被tomcat识别）的规则；
  
  - 定义一个类，实现Servlet接口，复写其中的方法；
  
    ![Servlet](web.assets/Servlet.bmp)

### Servlet快速入门

1. 创建javaEE项目；

2. 定义一个Java类实现Servlet接口

   ```java
   public class ServletDemo01 implements Servlet{}
   ```

3. 实现接口中的抽象方法

4. 配置Servlet（使用web.xml文件中配置Servlet）

   ```xml
       <!--配置Servlet-->
       <servlet>
           <servlet-name>demo01</servlet-name>
           <!--配置全类名-->
           <servlet-class>Servlet.ServletDemo1</servlet-class>
       </servlet>
   
   	<!--映射-->
       <servlet-mapping>
           <servlet-name>demo01</servlet-name>
           <!--可以重复-->
           <url-pattern>/demo01</url-pattern>
           <url-pattern>/demo111</url-pattern>
       </servlet-mapping>
   ```

   - 执行原理

     <img src="web.assets/Servlet执行原理-1601285936301.bmp" alt="Servlet执行原理" style="zoom: 200%;" />

     1. 当服务器接收到客户端浏览器的请求之后，会解析URL路径，获取访问的Servlet的资源路径；
     2. 查找web.xml文件，检索是否具有对应的<url-pattern>标签体内容；若存在，则找到对应的<servlet-class>的全类名；
     3. tomcat将字节码文件加载至内存，并创建对象；
     4. 调用其方法

   - Servlet的生命周期：

     1. 创建:Servlet被创建时会执行init方法，且只执行一次

        - Servlet什么时候会被创建？

          > 1. 默认情况下，Servlet在第一次被访问时由tomcat创建
          >
          > 2. 也可以通过配置确定Servlet的创建时机
          >
          >    ```xml
          >    可以在web.xml配置文件中配置，确定Servlet的创建时间：
          >    	在<servlet>标签下配置：
          >        1. 设置在第一次被访问时创建对象：
          >            <load-on-startup>的值为负数
          >        2. 设置在服务器启动时创建对象:
          >            <load-on-startup>的值为0或正整数
          >    ```

        - 注意：Servlet的实现对象是个单例

          > - 由Servlet中的init方法只被执行一次可以看出，Servlet在内存中只存在一个对象，
          >   即Servlet是单例的。
          >
          > - 多线程访问时，可能存在线程安全问题。
          >
          >   解决方案：
          >
          >   	1. 尽量不要在Servlet中定义成员变量；
          >   
          >    	2. 即使定义了成员变量，也不要修改其值
        
     2. 提供服务：执行service方法，service方法可以被执行多次

        - 每次访问Servlet时，service方法都会调用一次

     3. 销毁：执行destroy方法，只执行一次

        - 只有服务器正常关闭时，才会调用destroy方法；
        - destroy方法在Servlet被销毁前调用，一般用于释放资源

   - Servlet3.0  （支持使用注解方式配置Servlet，可不依赖web.xml配置Servlet）

     - 步骤：
       1. 创建javaEE项目，选择Servlet版本3.0及以上，可以不创建web.xml
       2. 定义类实现Servlet接口；
       3. 复写方法；
       4. 在该类上使用@WebServlet 注解配置Servlet

     > ```java
     > //WebServlet接口的定义及说明
     > @Target({ElementType.TYPE})
     > @Retention(RetentionPolicy.RUNTIME)
     > @Documented
     > public @interface WebServlet {
     >     String name() default "";//相当于xml配置中的<servlet-name>
     > 
     >     String[] value() default {};//表示urlPatterns（）属性配置
     > 
     >     String[] urlPatterns() default {};//<url-pattern>
     > 
     >     int loadOnStartup() default -1;//<load-on-startup>
     > 
     >     WebInitParam[] initParams() default {};
     > 
     >     boolean asyncSupported() default false;
     > 
     >     String smallIcon() default "";
     > 
     >     String largeIcon() default "";
     > 
     >     String description() default "";
     > 
     >     String displayName() default "";
     > }
     > ```

     - 实际写法举例

       ```java
       //三种写法效果一样
       @WebServlet("/annotationServlet")
       @WebServlet(urlPatterns = "/annotationServlet")
       @WebServlet(value = "/annotationServlet")
       ```

       > 注意：
       >
       > - 配置Servlet访问路径时，一个Servlet可以定义多个访问路径。如：
       >
       >   `@WebServlet({"/demo","/demo1","/demo2"})`
       >
       > - 路径定义规则:
       >   - /xxx:路径匹配
       >   - /xxx/xxx；多层路径，目录结构
       >   - *.do;扩展名匹配（自定义扩展名）

   - Servlet体系结构

     Servlet (接口)

     GenericServlet（实现Servlet的抽象类）

     HttpServlet（GenericServlet的子类，抽象类）

     - GenericServlet：将Servlet接口中其他方法做了默认空实现，只将service（）方法作为抽象方法。即定义Servlet类时，可以直接继承GenericServlet，实现service（）方法即可；
     - HttpServlet：对http协议的一种封装，简化操作
       1. 定义类继承HttpServlet
       2. 复写doGet/doPost方法

## HTTP

- 概念：Hyper Text Transfer Protocol 超文本传输协议

  - 传输协议：定义客户端-服务器通信的数据格式
  - 特点
    - 基于TCP/IP协议
    - 默认端口号80
    - 基于请求/响应模型：一次请求对应一次响应
    - 无状态：每次请求之前相互独立，不能交互数据
  - 历史版本
    - 1.0 ：每次请求响应都会建立新的连接
    - 1.1：复用连接

- 请求消息数据格式

  1. 请求行（请求方式   请求URL  请求协议/版本）

     ​						GET            login.html           HTTP/1.1

     - 请求方式（HTTP协议有7种请求方式，最常见的是GET和POST）

       - GET
         - 请求参数在请求行中，在URL后；
         - 请求的URL长度有限制
         - 相较不太安全
       - POST
         - 请求参数在请求体中
         - 请求的URL长度没有限制
         - 相较安全
     
  2. 请求头（客户端的浏览器告诉服务器一些信息）

       - 格式：请求头名称 ： 请求头值

       - 常见的请求头

         1. User-Agent ：客户端浏览器告诉服务器，所使用的浏览器版本信息；

            > 作用：可在服务器端获取到该头信息，用于解决浏览器的兼容性问题；

         2. Referer：http://localhost/login.html

            Referer头用于告诉服务器，当前请求从何处来

            > 作用：1.防盗链 ；2.做站点统计

  3. 请求空行

    用于分割POST请求的请求头和请求体

  4. 请求体（正文）

    请求体用于封装POST请求消息的请求参数

- 请求消息数据字符串格式

  ```html
  //POST方式（POST请求，请求参数在请求体中）
  //请求行
  POST /AnnotaionServlet/hehe.html HTTP/1.1
  //请求头
  Host: localhost:8080
  User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Content-Type: application/x-www-form-urlencoded
  Content-Length: 18
  Origin: http://localhost:8080
  Connection: keep-alive
  Referer: http://localhost:8080/AnnotaionServlet/login.html
  Upgrade-Insecure-Requests: 1
  //请求空行
  
  //请求体（正文）(未解析时是等号，浏览器解析之后以分号显示)
  username = zhangsan
  ```
  

## Request

### 1. Request&Response对象

- request和response对象由服务器创建；
- request对象用于获取请求消息，response对象用于设置响应消息；

### 2. request对象继承体系结构

> ServletRequest		--	接口
> 		|	继承
> HttpServletRequest	-- 接口
> 		|	实现
> org.apache.catalina.connector.RequestFacade 类(tomcat)

### 3. request功能

#### 1. 获取请求消息数据

1. 获取请求行数据

   - 请求行数据示例：GET /虚拟目录/demo1?name=zhangsan HTTP/1.1

   - 方法

     > - 获取请求方式：GET
     >
     >   `String getMethod()`
     >
     > - **获取虚拟目录：/虚拟目录**
     >
     >   `String getCOntextPath()`
     >
     > - 获取Servlet路径: /demo1
     >
     >   `String getServletPath()`
     >
     > - 获取get方式请求参数:name=zhangsan
     >
     >   `String getQueryString()`
     >
     > - **获取请求URI：/虚拟目录/demo1**
     >
     >   `String getRequestURI():		/day14/demo1`
     >
     >   `StringBuffer getRequestURL()  :http://localhost/虚拟目录/demo1`
     >
     >   注意：
     >
     >   1. URL:统一资源定位符 ： http://localhost/虚拟目录/demo1
     >   2. URI：统一资源标识符 : /虚拟目录/demo1
     >
     > - 获取协议及版本:HTTP/1.1
     >
     >   `String getProtocol()`
     >
     > - 获取客户机IP
     >
     >   `String getRemoteAddr()`

2. 获取请求头数据

   > 方法：
   >
   > - **String getHeader(String name):通过请求头的名称获取请求头的值**
   > - Enumeration<String> getHeaderNames():获取所有的请求头名称

3. 获取请求体数据

   - 请求体：只有POST请求方式才有请求体，在请求体中封装了POST请求的请求参数；

   - 步骤：

     1. 获取流对象

        > 方法
        >
        > - BufferedReader getReader()：获取字符输入流，只能操作字符数据
        > - ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据（文件上传中详细说明）

     2. 从流对象中取数据

#### 2. 其他功能

1. 获取请求参数通用方式：GET/POST方式都可以通过下列方法获取请求参数

   > 方法
   >
   > - String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
   > - String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game（复选框数据处理可使用）
   > - Enumeration<String> getParameterNames():获取所有请求的参数名称
   > - Map<String,String[]> getParameterMap():获取所有参数的map集合
   >
   > 注意：关于中文乱码问题
   >
   > get方式：tomcat 8 已经将get方式的中文乱码问题解决；
   >
   > post方式：会乱码
   >
   > ​						处理方式：在获取参数前设置request的编码：
   >
   > ​                    `request.setCharacterEncoding("utf-8")`		

2. 请求转发：一种**服务器内部**的资源跳转

   >步骤：
   >
   >1. 通过request对象获取请求转发器对象
   >
   >   `RequestDispatcher getRequestDispatcher(String path)`
   >
   >2. 使用RequestDispatcher对象来进行转发
   >
   >   `forward(ServletRequest request, ServletResponse response) `
   >
   >**请求转发特点：**
   >
   >1. 浏览器地址栏路径不会发生变化
   >2. 只能转发到当前服务器内部资源
   >3. 转发是在一次请求中

3. 共享数据

   - 域对象：一个有作用范围的对象，可以在范围内共享数据；

   - request域：代表一次请求的范围，一般用于在**请求转发的多个资源中**共享数据

     > 方法：
     >
     > - void setAttribute(String name,Object obj) ：存储数据
     > - Object getAttitude(String name)：通过键获取值
     > - void removeAttribute(String name)：通过键移除键值对

4. 获取ServletContext

   `ServletContext getServletContext()`

### 4. 登录案例

> 用户登录案例需求：
>
> 1. 编写login.html登录页面 username & password 两个输入框
> 2. 使用Druid数据库连接池技术,操作mysql，day14数据库中user表
> 3. 使用JdbcTemplate技术封装JDBC
> 4. 登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
> 5. 登录失败跳转到FailServlet展示：登录失败，用户名或密码错误

```java
//步骤
//1.创建项目，导入html页面，JDBC配置文件，依赖jar包
//2.创建数据库环境
    CREATE	DATABASE USERS;
    USE USERS;
    CREATE TABLE USER(
        id 	INT PRIMARY KEY AUTO_INCREMENT,
        username VARCHAR(32) UNIQUE NOT NULL,
        PASSWORD VARCHAR(32) NOT NULL
    );
//3.创建包domain.User(domain package下创建User)
	- 创建用户实体类，提供set、get方法，重写toString方法
//4.创建包util.JDBCUtils（util package下创建工具类JDBCUtils） 
    - JDBC工具类，使用Durid连接池
    - 加载JDBC配置文件
    - 获取连接池对象
    - 获取连接对象
//5.创建包dao.UserDao(dao package 下创建UserDao，并提供login方法)
    - 声明JdbcTemplate对象，共用
    - login方法体中，编写sql，调用query方法获取查询结果（user对象，可能为null）
//6.创建包web.servlet.LoginServlet(创建web package，其下创建servlet package,在其中创建LoginServlet)
    - 设置编码
    - 获取请求参数
    - 封装user对象
    - 调用UserDao的login方法
    - 通过user值是否为空，判断查询结果。若成功，存储域数据，转发至successServlet；若失败，转发至failServlet
//7.在servlet package 下创建FailServlet和SuccessServlet类
    SuccessServlet：
    - 获取request域中共享的user对象
    - 输出（设置编码，输出）
    FailServlet：
    - 设置编码
    - 输出
//8.login.html中form表单的action路径的写法
    虚拟目录+Servlet的资源路径
//9.BeanUtils工具类的使用：简化数据封装
    用于封装JavaBean的
    - JavaBean：标准的Java类
        1. 要求：
        	1. 类必须被public修饰
            2. 必须提供空参的构造器
            3. 成员变量必须使用private修饰
            4. 提供公共setter和getter方法
        2. 功能：封装数据
    - 概念：
        成员变量 VS 属性
        属性：setter和getter方法截取后的产物。
        如： getUsername() --> Username--> username
    - 方法：
        1. setProperty()
        2. getProperty()
        3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中


```

