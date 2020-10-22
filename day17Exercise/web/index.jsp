<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div align="right">来自${user.address}的${user.name}，欢迎您！</div>
<div align="right">现在是<%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%></div> <%--页面时间可以做成每隔一秒刷新--%>
<div align="center">
    <%--这里为什么可以使用request域进行指定？--%>

    <a
           <%-- href="/day17Exercise/userListServlet" style="text-decoration:none;font-size:33px">查询所有用户信息--%>
            <%--使用EL表达式动态获取虚拟目录，不直接写死--%>
            <%--这里跳转是不带参数的跳转，后端做健壮性处理（初次无参数时进行赋值操作）--%>
            href="${pageContext.request.contextPath}/findUserByPageServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
</div>
</body>
</html>
