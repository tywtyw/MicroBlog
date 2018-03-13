<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/7
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>

<form action="addUser" method="post">
    请输入用户名<input type="text" name="username"><br>
    请输入密码<input type="password" name="password"><br>
    请再次输入密码<input type="password" name="repassword"><br>
    <input type="submit" value="提交">
</form>


</body>
</html>
