package servlet;

import bean.User;
import dao.FriendDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showFollowerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uId = user.getId();
        List<User> userList = new FriendDAO().showFollower(uId);
        request.getSession().setAttribute("followerList",userList);
        String flag = "1";
        request.getSession().setAttribute("flagShow",flag);
        request.getRequestDispatcher("showFollowerOrFan.jsp").forward(request,response);
    }
}
