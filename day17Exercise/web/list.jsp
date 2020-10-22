<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id,name) {
            //用户安全提示
            if (confirm("您确定要删除 "+name+" 用户的数据么")){
                //访问路径
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        //删除选定 的点击事件
        window.onload = function () {
            document.getElementById("delSelected").onclick = function () {

                if (confirm("您确定要删除选中条目吗？")){

                    var flag = false;
                    //判断是否有选中的checkCode被选中

                        //遍历看是否有checkbox被选中
                    let cbs = document.getElementsByName("uid");
                    for (let i =0; i < cbs.length; i++){
                        //设置状态
                        if (cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    //防止一个选中的没有形成空指针
                    if (flag)
                    {
                        //获取form并提交
                        document.getElementById("form").submit();/*submit 为表单提交方法*/
                    }
                }

            }

            //第一行 同状态操作（全选，全部选）
            document.getElementById("firstCb").onclick = function () {
                //获取列表中除了第一个所有的cb
                let cbs = document.getElementsByName("uid");  //注意不是getElementById
                //遍历
                for (let i =0; i < cbs.length; i++){
                    //设置状态
                    cbs[i].checked = this.checked;
                }

            }

        }


    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
<%--bootstrap 内联表单--%>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post" >
            <div class="form-group">
                <%--label标签的for属性和下面的input对应起来即可，可以实现点击的联动--%>
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" value="${requestScope.condition.name[0]}" name="name" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="text" class="form-control" value="${requestScope.condition.address[0]}" name="address" id="exampleInputEmail2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail3">邮箱</label>
                <input type="text" class="form-control" value="${requestScope.condition.email[0]}" name="email" id="exampleInputEmail3" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加用户</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a><%--通过id绑定点击事件--%>

    </div>

    <%--通过form表单提交checkbox状态--%>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedCheckBoxsServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success"><%--checkbox复选删除时不需要提交--%>
                <th><input type="checkbox" id="firstCb" ></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <%--判集合非空后进行数据操作--%>
            <%--pageBean.list中存放的就是users--%>
            <c:if test="${not empty requestScope.pageBean.list}" >
                <%--pageBean.list中存放的就是users--%>
                <c:forEach items="${requestScope.pageBean.list}" var="user" varStatus="s">
                    <tr>
                        <td><input type="checkbox" name="uid" value="${user.id}"></td>
                        <td>${s.count}</td>  <%--注意，这里表单显示的序号并不是真实的user id ，真实的user id 是自增长的（数据库中自增长太长该怎么办）--%>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;
                                <%--js 多参数传递 ’‘，’‘--%>
                            <a class="btn btn-default btn-sm" href="javascript:deleteUser('${user.id}','${user.name}')">删除</a><%--使用JavaScript添加删除警告--%><%--传参 id--%>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>



            <%--后面需要写一个错误页面errorPage(使用属性)--%>
            <%--<c:if test="${empty requestScope.users}">

            </c:if>--%>



            <%--<tr>
                <td colspan="8" align="center"><a class="btn btn-primary" href="add.html">添加联系人</a></td>
            </tr>--%>
        </table>
    </form>


</div>
<%--分页工具条--%>
<div align="center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <%--上一页--%>

            <%--禁用(仅显示)控制--%>
            <c:if test="${requestScope.pageBean.currentPage == 1}">
                <li class="disabled">
            </c:if>
            <c:if test="${requestScope.pageBean.currentPage != 1}">
                <li>
            </c:if>

                <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage - 1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

                <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i">
                    <%--<li><a href=${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5>${i}</a></li>--%>
                    <%--禁用激活状态设置--%>
                    <c:if test="${requestScope.pageBean.currentPage == i}">
                        <li class="active"><a href=${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}>${i}</a></li>
                    </c:if>
                    <c:if test="${requestScope.pageBean.currentPage != i}">
                        <li><a href=${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}>${i}</a></li>
                    </c:if>
                </c:forEach>
                <%--下一页--%>
                <c:if test="${requestScope.pageBean.currentPage == requestScope.pageBean.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${requestScope.pageBean.currentPage != requestScope.pageBean.totalPage}">
                    <li>
                </c:if>
<%--requestScope.pageBean.currentPage + 1--%>
                    <%--requestScope.pageBean.currentPage = requestScope.pageBean.currentPage == requestScope.pageBean.totalPage ? requestScope.pageBean.totalPage : (requestScope.pageBean.currentPage+1)--%>

                <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage + 1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span  style="font-size: 22px;float: right;color: #2b669a">
                    共${requestScope.pageBean.totalCount}条记录，共${requestScope.pageBean.totalPage}页
                </span>
        </ul>
    </nav>
</div>
</body>
</html>
