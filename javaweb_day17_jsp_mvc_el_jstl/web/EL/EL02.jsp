<%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/19
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL02:EL获取域对象中的数据</title>
</head>
<body>
    <%--域中存入对象--%>
<%
    session.setAttribute("name","张三");
    request.setAttribute("name","李四");
    session.setAttribute("age","20");
    request.setAttribute("str","");
%>

<h3>EL表达式获取值</h3>
${requestScope.name}
${requestScope.str}
${requestScope.test}  <%--没有对应的数据直接打印空字符串--%>

    <hr/>
<%--没有指定具体的域，临近，使用范围最小的域--%>
${name} <%--使用request域--%>
${sessionScope.name}
</body>
</html>
