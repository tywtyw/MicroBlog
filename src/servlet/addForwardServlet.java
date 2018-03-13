package servlet;

import dao.ForwardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int uId = (Integer)request.getSession().getAttribute("uId");

        int bId = (Integer)request.getSession().getAttribute("bId2");

        String forwardData = (String)request.getParameter("forward");

        new ForwardDAO().addForward(uId,bId,forwardData);

        request.getRequestDispatcher("showMessage").forward(request,response);
    }
}
