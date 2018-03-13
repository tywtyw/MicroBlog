<%@ page import="java.util.List" %>
<%@ page import="bean.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.CommentDAO" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/14
  Time: 19:45
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
    int bId1 = Integer.parseInt(request.getParameter("bId1"));
    List<Comment> commentList = new CommentDAO().showComment(bId1);
    request.setAttribute("commentList",commentList);
%>
<h2 align="center">
    总共有${requestScope.commentList.size()}条评论
</h2>
<c:forEach items="${requestScope.commentList}" var="comment" varStatus="st">
    <table align="center">
        <tr>
            <td>
                ${st.count}
            </td>
            <td>
                ${comment.getuUser().getUsername()}：
            </td>
            <td>
                ${comment.getComment()}
            </td>
            <td>
                <%--两种情况，第一种登陆的用户是发表评论的用户，有权限删除自己的评论
                第二种是登录的用户查看自己的微博，有权删除自己的发表微博下的所有评论--%>
                <c:if test="${sessionScope.user.getId()==comment.getuUser().getId()
                or sessionScope.user.getId()==comment.getBlog().getUser().getId()}">
                    <form action="deleteComment" method="post">
                        <input type="hidden" name="deleteComId" value="${comment.getId()}">
                        <input type="submit" value="删除">
                    </form>
                </c:if>
            </td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
