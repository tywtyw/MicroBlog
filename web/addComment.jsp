<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/14
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User)request.getSession().getAttribute("user");
    int bId = Integer.parseInt(request.getParameter("bId"));
    int uId = user.getId();
    request.getSession().setAttribute("bId",bId);
    request.getSession().setAttribute("uId",uId);
%>
<h2 align="center">
    <form action="addComment" method="post">
    <table align="center" width="450px">
        <tr>
            <td>评论： </td>
            <td><textarea rows="10" cols="50" name="comment"></textarea></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
    </form>
</h2>
</body>
</html>
