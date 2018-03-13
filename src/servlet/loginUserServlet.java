package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginUserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDAO().getUser(username,password);

        if (null!=user){
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("info","您已经登录");
            request.getRequestDispatcher("afterLogin.jsp").forward(request,response);
        }

        else {
            request.getSession().setAttribute("info","请您先登录");
            response.sendRedirect("afterLogin.jsp");
        }
    }
}
