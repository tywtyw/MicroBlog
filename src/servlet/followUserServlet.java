package servlet;

import bean.User;
import dao.FriendDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class followUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int fId = Integer.parseInt(request.getParameter("fId"));
        User user = (User) request.getSession().getAttribute("user");
        int uId = user.getId();

        new FriendDAO().SetFollow(uId,fId);

        request.getRequestDispatcher("toSearchUser.jsp").forward(request,response);

    }
}
