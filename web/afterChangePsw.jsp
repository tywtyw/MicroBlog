<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/9
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">
<%
    String infoPsw = (String) request.getSession().getAttribute("infoPsw");
if (infoPsw.endsWith("为空") || infoPsw.endsWith("不一致") || infoPsw.endsWith("错误")){
        out.println(infoPsw);
%>
    <a href="changePassword.jsp">重新修改密码</a>
<%
    }
    else {
        out.println(infoPsw);
%>
    <a href="afterLogin.jsp">返回</a>
    <%
        }
    %>
</p>
</body>
</html>
