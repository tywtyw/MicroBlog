<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/12
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="bean.*"%>
<%@ page import="dao.FriendDAO" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center">
    <tr>
        <td>
            <a href="myInformation.jsp">返回主页</a>
        </td>
    </tr>
    <tr>
        <td>
<%
    User user = (User)request.getSession().getAttribute("user");
    User searchUser = (User) request.getSession().getAttribute("searchUser");
    if (null==searchUser){
        out.println("您搜索的用户不存在");
    }
    else {
        out.println(searchUser.getUsername());
        boolean flag = new FriendDAO().checkFollow(user.getId(),searchUser.getId());
        request.setAttribute("flag",flag);
%>
        </td>
        <td>
            <form action="unFollowUser" method="post">
                <c:if test="${requestScope.flag}">
                <input type="hidden" name="unfId" value=${sessionScope.searchUser.getId()}>
                <input type="submit" value="取消关注">
                </c:if>
                </form>
            <form action="followUser" method="post">
                <c:if test="${!requestScope.flag}">
                    <input type="hidden" name="fId" value=${sessionScope.searchUser.getId()}>
                    <input type="submit" value="关注">
                </c:if>
            </form>
        </td>
        <td>
            <form action="showFriendMessage" method="post">
                <input type="hidden" name="fUser" value=${sessionScope.searchUser.getUsername()}>
                <input type="submit" value="查看他的微博">
            </form>
        </td>
    </tr>
</table>
<%
    }
%>
</body>
</html>
