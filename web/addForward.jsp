<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/15
  Time: 10:01
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
    int bId2 = Integer.parseInt(request.getParameter("bId2"));
    int uId = user.getId();
    request.getSession().setAttribute("bId2",bId2);
    request.getSession().setAttribute("uId",uId);
%>
<h2 align="center"></h2>
<table align="center">
    <form action="addForward" method="post">
        <tr>
            <td>
                转发：
            </td>
            <td>
                <textarea name="forward" cols="50" rows="10"></textarea>
            </td>
            <td>
                <input type="submit" value="转发">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
