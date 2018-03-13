package servlet;

import bean.User;
import dao.FriendDAO;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class unFollowUserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int f_id = Integer.parseInt(request.getParameter("unfId"));
        User user = (User) request.getSession().getAttribute("user");

        new FriendDAO().unFollow(user.getId(),f_id);

        request.getRequestDispatcher("toSearchUser.jsp").forward(request,response);
    }
}
