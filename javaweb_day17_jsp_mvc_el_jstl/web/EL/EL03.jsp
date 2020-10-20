<%@ page import="domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 18395
  Date: 2020/10/19
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL03获取对象、List、Map数据</title>
</head>
<body>
    <%--模拟对象、List、Map数据--%>
    <%
        User user = new User("张三", "123", new Date());
        request.setAttribute("user",user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","一");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);

    %>
    <hr/>

    <%--取数据--%>
    <h3>EL获取对象中的数据</h3>
    <%--
    通过对象的 属性 来获取
        setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写。
        setName --> Name --> name
    --%>
    ${requestScope.user}<br>
    ${requestScope.user.username}<br>
    ${requestScope.user.password}<br>
    ${requestScope.user.birthday}<br>
    <%--利用逻辑视图获取优化过的时间信息--%>
    ${requestScope.user.birStr}
    <hr/>

    <h3>EL获取List中的数据</h3>
    ${requestScope.list}<br>
        <%--省略域名称--%>
    ${list}<br>
    ${list[0]}<br>
    ${list[2].username}<br>
    ${list[100]}<br>  <%--角标越界不报错，打印空串（不打印）--%>


    <h3>EL获取Map中的数据</h3>
    ${requestScope.map.sname}<br>
    ${requestScope.map.gender}<br>
    ${map["gender"]}<br>


    ${map.user.username}<br>




</body>
</html>
