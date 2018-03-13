<%@ page import="java.util.List" %>
<%@ page import="bean.Forward" %>
<%@ page import="dao.ForwardDAO" %><%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/15
  Time: 10:50
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
    int blogId = Integer.parseInt(request.getParameter("bId3"));
    List<Forward> forwardList = new ForwardDAO().getForward(blogId);
    request.setAttribute("forwardList",forwardList);
%>
<h2 align="center">
    总共有${requestScope.forwardList.size()}条转发
</h2>
<c:forEach items="${requestScope.forwardList}" var="forward" varStatus="st">
    <table align="center">
        <tr>
            <td>
                ${forward.getUser().getUsername()} 转发了：
            </td>
            <td>
                ${forward.getBlog().getBlog()}
            </td>
            <td>
                并说：${forward.getForwardData()}
            </td>
            <td>
                <c:if test="${sessionScope.user.getId()==forward.getUser().getId()}">
                    <form action="deleteForward" method="post">
                        <input type="hidden" name="deleteForId" value="${forward.getId()}">
                        <input type="submit" value="删除">
                    </form>
                </c:if>
            </td>
        </tr>
    </table>
</c:forEach>

</body>
</html>
