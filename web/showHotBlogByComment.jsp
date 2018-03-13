<%@ page import="java.util.List" %>
<%@ page import="bean.Blog" %>
<%@ page import="dao.BlogDAO" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/15
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ page import="bean.Blog" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Blog>blogList = new BlogDAO().hotBlogByComment();
    request.setAttribute("hotBlogByComment",blogList);
%>
<c:forEach items="${requestScope.hotBlogByComment}" var="blog" varStatus="st">
    <table align="center">
        <tr>
            <td>
                ${st.count}
            </td>
            <td>
                ${blog.getBlog()}
            </td>
            <td>
                共有${blog.getCommentCount()}条评论
            </td>
            <td>
                共有${blog.getForwardCount()}条转发
            </td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
