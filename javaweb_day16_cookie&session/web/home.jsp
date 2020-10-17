<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/16
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homePage</title>
    <style>
        .attention1{
            color: red;
        }
        .attention2{
            color: blue;
        }
    </style>
</head>
<body>
<%
    //设置编码
    response.setContentType("text/html;charset=utf-8");

    //判断Cookie中是否含有lastTime键，标志
    boolean flag = false;

    //获取cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie c :
                cookies) {
            String name = c.getName();
            if ("lastTime".equals(name)) {
                flag = true;

                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = simpleDateFormat.format(date);
                //编码 特殊字符（空格）
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("编码后：" + str_date);
                //设置lastTime值为新的时间
                c.setValue(str_date);
                //设置cookie存活时间为一个月
                c.setMaxAge(5);
                //更新cookie（包含新时间）
                response.addCookie(c);
                //获取老cookie中的数据，键为lastTime的value
                String value = c.getValue();
                //URL解码：
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后：" + value);
                %>
                <h1 class="attention1">欢迎回来，您上次访问时间为: <%= value%> </h1>
                <%
                System.out.println("中国字测试");
                break;

            }

        }


    }

    if (cookies == null || cookies.length == 0 || flag == false) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");

        String str_date = simpleDateFormat.format(date);

        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后：" + str_date);

        Cookie cookie = new Cookie("lastTime", str_date);


        cookie.setMaxAge(5);


        response.addCookie(cookie);

        //URL解码：
        str_date = URLDecoder.decode(str_date, "utf-8");
        System.out.println("解码后：" + str_date);
%>
<%--out.write("<h1>您好，这是首次访问，访问时间："+str_date+"</h1>");--%>
<h1 class="attention2">您好，这是首次访问，访问时间：<%=str_date%></h1>

<%
        System.out.println("中国字");

    }

%>
<hr/>

<input>

</body>
</html>
