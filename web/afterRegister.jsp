<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/7
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>注册信息</title>
</head>
<body>
<%
    String info = (String) request.getSession().getAttribute("info");
    if (info.equals("1")){
        out.println("两次输入密码不一致，请重新注册");
%>
<a href="register.jsp">注册</a>
<%
    }
%>


<%
    if (info.equals("2")){
        out.println("用户名已存在，请重新注册");
%>
<a href="register.jsp">注册</a>
<%
    }
%>

<%
    if (info.equals("3")){
        out.println("注册成功，请登录");
%>
<a href="login.jsp">登录</a>
<%
    }
%>
</body>
</html>
