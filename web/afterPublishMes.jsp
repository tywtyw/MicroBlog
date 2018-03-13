<%--
  Created by IntelliJ IDEA.
  User: tyw
  Date: 2017/12/11
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String infoblog = (String)request.getSession().getAttribute("infoblog");
    if (infoblog.endsWith("空")){
        out.println(infoblog);
%>
<a href="publishMessage.jsp">发表微博</a>
<%
    }
    else {
        out.println(infoblog);
    }
%>
<a href="afterLogin.jsp">返回主页</a>
</body>
</html>
