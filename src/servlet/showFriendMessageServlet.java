package servlet;

import bean.Blog;
import bean.User;
import dao.BlogDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showFriendMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fUsername = request.getParameter("fUser");

        User fUser = new UserDAO().searchUser(fUsername);
        List<Blog> blogs = new BlogDAO().showAllBlog(fUser);

        request.getSession().setAttribute("blogList",blogs);
        request.getRequestDispatcher("showMessage.jsp").forward(request,response);
    }
}
