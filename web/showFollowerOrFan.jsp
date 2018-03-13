<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/13
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="bean.*"%>
<%@ page import="java.util.List" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${sessionScope.flagShow eq '1'}">
<table align="center">
    <tr>
        <td>
            您关注的人有:
        </td>
    </tr>
    <c:forEach items="${sessionScope.followerList}" var="user" varStatus="st">
        <tr>
            <td>
                      ${user.getUsername()}
            </td>
            <td>
                <form action="showFriendMessage" method="post">
                    <input type="hidden" name="fUser" value="${user.getUsername()}">
                    <input type="submit" value="查看他的微博">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>


<c:if test="${sessionScope.flagShow eq '2'}">
    <table align="center">
        <tr>
            <td>
                您的粉丝有:
            </td>
        </tr>
        <c:forEach items="${sessionScope.fansList}" var="user" varStatus="st">
            <tr>
                <td>
                        ${user.getUsername()}
                </td>
                <td>
                    <form action="showFriendMessage" method="post">
                        <input type="hidden" name="fUser" value="${user.getUsername()}">
                        <input type="submit" value="查看他的微博">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
