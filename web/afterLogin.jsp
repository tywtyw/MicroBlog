<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/8
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<div align="center">
    提示信息
</div>
<p align="center">
    <%
        String info = (String) request.getSession().getAttribute("info");
        if (info.startsWith("您")){
            out.println(info);
            %>
<p align="center" class="div1">
    <a href="register.jsp">用户注册</a> <a href="login.jsp">用户登录</a>
    <a href="information.jsp">当前用户</a> <a href="ExitServlet">用户退出</a>
    <a href="myInformation.jsp">我的主页</a> <a href="showMessage">我的微博</a>
    <a href="publishMessage.jsp">发表微博</a> <a href="showHotBlogByComment.jsp">查看最热微博(评论数)</a>
    <a href="showHotBlogByForward.jsp">查看最热微博(转发数)</a> <a href="changePassword.jsp">修改密码</a>
</p>
    <%
        }
        else {
            out.println(info);
    %>
    <a href="login.jsp">登录</a>
    <%
        }
    %>
</p>
</body>
</html>
