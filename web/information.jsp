<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提示信息</title>
</head>

<body>
	<div align="center">
		<div class="div1">
			<div class="top">提示信息</div>
			<div class="bottom">
				<div class="div2">
					<a href="register.jsp">用户注册</a> <a href="login.jsp">用户登录</a> <a
						href="information.jsp">当前用户</a> <a href="ExitServlet">用户退出</a> <a
						href="myInformation.jsp">我的主页</a> <a href="ShowMessageServlet">我的微博</a>
					<a href="publishmessage.jsp">发表微博</a> <a href="ShowMyFriendServlet">我的关注</a>
					<a href="ShowMyFansServlet">我的粉丝</a> <a href="changepassword.jsp">修改密码</a>
				</div>
				<div class="div3">
					<%
						// 获取提示信息
						String info = (String) request.getAttribute("info");
						if (info != null) {
							out.println(info);
						}
						// 登录的用户信息
						User user = (User) session.getAttribute("user");
						// 是否登录
						if (user != null) {
					%>
					<table align="center" width="350" border="1" height="200">
						<tr>
							<td align="center" colspan="2"><%=user.getUsername()%>
								登录成功！ <a href="publishmessage.jsp">发表微博</a></td>
						</tr>

					</table>
					<%
						} else {
							out.println("<br>您还没有登录！");
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
