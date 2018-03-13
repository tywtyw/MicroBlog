package servlet;

import dao.CommentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteCommentServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deleteComId = Integer.parseInt(request.getParameter("deleteComId"));

        new CommentDAO().deleteComment(deleteComId);

        request.getRequestDispatcher("showMessage.jsp").forward(request,response);
    }
}
