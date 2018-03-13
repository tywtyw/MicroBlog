package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class searchUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchName = request.getParameter("searchUser");

        User searchUser = new UserDAO().searchUser(searchName);

        request.getSession().setAttribute("searchUser",searchUser);
        request.getRequestDispatcher("toSearchUser.jsp").forward(request,response);
    }
}
