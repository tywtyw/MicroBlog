<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/7
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>


<body>
<table align="center">

    <form action="login" method="post">
        <input type="text" name="username" value="username"><br>
        <input type="password" name="password" value="password"><br>
        <input type="submit" value="登录">
    </form>
    <a href="register.jsp"><input type="submit" value="注册"></a>

</table>
</body>
</html>
