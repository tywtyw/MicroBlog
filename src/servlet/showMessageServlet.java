package servlet;

import bean.Blog;
import bean.User;
import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<Blog>blogs = new BlogDAO().showAllBlog(user);

        request.getSession().setAttribute("blogList",blogs);
        request.getRequestDispatcher("showMessage.jsp").forward(request,response);
    }
}
