<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <c:if test="true">
        <h4>TRUE</h4>
    </c:if>
<hr/>
    <%
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);
        request.setAttribute("number",4);

    %>

    <c:if test="${not empty list}">
        <P>集合非空，遍历集合</P>
    </c:if>
    <hr/>


    <%--if else 结构--%>
    <c:if test="${number % 2 !=0}">
        <p>${number}为奇数</p>
    </c:if>
    <c:if test="${number % 2 == 0}">
        <p>${number}为偶数</p>
    </c:if>

</body>
</html>
