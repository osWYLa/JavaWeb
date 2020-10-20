<%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/19
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>访问出错啦</title>
</head>
<body>
    <h4 align="center">您访问的网址不见了。。。</h4>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
