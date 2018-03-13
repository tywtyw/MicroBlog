<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/11
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">
<%
    User user = (User)request.getSession().getAttribute("user");
    out.println("欢迎用户"+user.getUsername());
%>
    <br>
    和大家分享一点有趣的事情吧
<form action="publishMessage" method="post">
    <table align="center" width="450" border="0">
    <tr>
        <td  align="right">微博： </td>
        <td><textarea rows="10" cols="50" name="blog"></textarea></td>
    </tr>
        <tr>
            <td align="right">
                <input type="submit" value="发布">
            </td>
            <td align="center">
                <input type="reset" value="重置">
            </td>
        </tr>
</table>
</form>
</p>
</body>
</html>
