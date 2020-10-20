<%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的隐式对象</title>
</head>
<body>
    ${pageContext.request}<br>
    <h4>在JSP页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}
</body>
</html>
