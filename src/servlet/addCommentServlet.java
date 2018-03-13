package servlet;

import bean.Comment;
import bean.User;
import dao.CommentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class addCommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int bId = (Integer)request.getSession().getAttribute("bId");

        int uId = (Integer)request.getSession().getAttribute("uId");


        String comment = (String)request.getParameter("comment");



        new CommentDAO().addComment(uId,bId,comment);



        request.getRequestDispatcher("showMessage.jsp").forward(request,response);
    }
}
