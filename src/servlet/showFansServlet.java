package servlet;

import bean.User;
import dao.FriendDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showFansServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int fId = user.getId();

        List<User> userList = new FriendDAO().showFan(fId);

        request.getSession().setAttribute("fansList",userList);

        request.getSession().setAttribute("flagShow","2");

        request.getRequestDispatcher("showFollowerOrFan.jsp").forward(request,response);
    }
}
