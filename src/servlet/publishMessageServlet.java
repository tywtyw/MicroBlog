package servlet;

import bean.User;
import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class publishMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String blogdata = request.getParameter("blog");
        User user = (User)request.getSession().getAttribute("user");
        if (blogdata.length() == 0){
            request.getSession().setAttribute("infoblog","发表的微博不能为空");
            request.getRequestDispatcher("afterPublishMes.jsp").forward(request,response);
        }
        else {
            request.getSession().setAttribute("infoblog","发表微博成功");
            new BlogDAO().insert(user,blogdata);
            request.getRequestDispatcher("afterPublishMes.jsp").forward(request,response);
        }
    }
}
