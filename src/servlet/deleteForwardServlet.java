package servlet;

import dao.ForwardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deleteForId = Integer.parseInt(request.getParameter("deleteForId"));

        new ForwardDAO().deleteForward(deleteForId);

        request.getRequestDispatcher("showMessage.jsp").forward(request,response);
    }
}
