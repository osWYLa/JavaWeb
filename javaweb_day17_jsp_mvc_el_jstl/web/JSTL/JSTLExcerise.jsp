<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL练习</title>
</head>
<body>
    <%
        /* 存储数据*/
        List<User> list = new ArrayList<>();
        list.add(new User("张三","123",new Date()));
        list.add(new User("李四","1234",new Date()));
        list.add(new User("王五","12345",new Date()));

        request.setAttribute("list",list);
    %>

<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>生日</th>
    </tr>

    <%--几行由list中元素个数决定--%>
    <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count % 2 !=0}">
            <tr bgcolor="#ffc0cb">
                <td>${s.count}</td>
                    <%--<td>${requestScope.user.username}</td>--%> <%--不可行 ，此时request域中根本没有user，这个user是foreach遍历获取的类似于局部变量的东西--%>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

        <c:if test="${s.count % 2 ==0}">
            <tr bgcolor="#7fffd4">
                <td>${s.count}</td>
                    <%--<td>${requestScope.user.username}</td>--%> <%--不可行 ，此时request域中根本没有user，这个user是foreach遍历获取的类似于局部变量的东西--%>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>

</body>
</html>
