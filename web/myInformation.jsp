<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/12
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的主页</title>
</head>
<body>
<p align="center">
<table align="center">
    <form action="searchUser" method="post">
        <tr>
            <td>
    <input type="text" name="searchUser" value="搜索用户" align="center">
    <input type="submit" name="搜索" align="center">
            </td>
        </tr>
</form>
</table>
</p>

<table align="center">
    <tr>
        <td>
            <a href="showFollower">我关注的人</a>
        </td>

        <td>
            <a href="showFans">我的粉丝</a>
        </td>
    </tr>
</table>


<h2 align="center">想说点什么</h2>
<p align="center">
<table align="center">
<form action="publishMessage" method="post">
<textarea name="blog" rows="10" cols="50" ></textarea>
<br>
<input type="submit" name="发表">
</form>
</table>
</p>




</body>
</html>
