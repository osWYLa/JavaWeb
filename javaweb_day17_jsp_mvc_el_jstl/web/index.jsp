<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" errorPage="errorPage_500.jsp" buffer="8kb" %>
<%@include file="top.jsp"%>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="ch" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  hello jsp
 <%-- <p>hello</p>--%>
  <!-- <p>hi</p> -->

  <%
    ArrayList<User> users = new ArrayList<>();
    /*int i = 3/0;*/
      pageContext.setAttribute("msg","中文");
  %>
  <%= pageContext.getAttribute("msg")%>
  </body>
</html>
