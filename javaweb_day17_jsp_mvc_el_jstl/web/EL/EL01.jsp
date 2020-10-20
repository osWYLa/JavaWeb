<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/19
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL01</title>
</head>
<body>
<h3>算数运算符</h3>
    \${ 3 > 4 } <hr/>
    ${ 3 + 4 } <hr/>
    ${ 3 / 4 } <hr/>
    ${ 3 % 4 } <hr/>
<h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>
<h4>empty运算符</h4>
    <%
        String str ="";
        request.setAttribute("str",str);
        List list = new ArrayList();
        request.setAttribute("list",list);
    %>
    ${ empty str}<br/>
    ${ empty list}<br/>

    ${not empty str}<br/>
    ${not empty list}<br/>
</body>
</html>
