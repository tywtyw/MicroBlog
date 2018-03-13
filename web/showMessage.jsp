<%@ page import="java.util.List" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/11
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ page import="bean.Blog" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>我的微博</title>
</head>
<body>
<p align="center">
<a href="afterLogin.jsp">返回主页</a>
</p>
<%
    List<Blog> blogList = (List<Blog>) request.getSession().getAttribute("blogList");
    %>
<c:forEach items="${blogList}" var="blog" varStatus="st">
<table align="center" width="200px" cellspacing="0">
    <tr>
        <td width="90%">
            ${blog.getBlog()}
        </td>
    </tr>
    <tr>
        <td>
            <c:if test="${sessionScope.user.getId()==blog.getUser().getId()}">
            <form action="deleteBlog" method="post">
                <input type="submit" value="删除">
                <input type="hidden" name="id" value=${blog.getId()}>
            </form>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>
            <form action="addComment.jsp" method="post">
                <input type="submit" value="评论">
                <input type="hidden" name="bId" value=${blog.getId()}>
            </form>
        </td>
        <td>
            <form action="showComment.jsp" method="post">
                <input type="submit" value="查看该条微博的评论">
                <input type="hidden" name="bId1" value="${blog.getId()}">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="addForward.jsp" method="post">
                <input type="submit" value="转发该条微博">
                <input type="hidden" name="bId2" value="${blog.getId()}">
            </form>
        </td>
        <td>
            <form action="showForward.jsp" method="post">
                <input type="submit" value="查看谁转发了该条微博">
                <input type="hidden" name="bId3" value="${blog.getId()}">
            </form>
        </td>
    </tr>
</table>
</c:forEach>
</body>
</html>
