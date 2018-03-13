package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class changePasswordServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        User user = (User) request.getSession().getAttribute("user");
        String prePassword = user.getPassword();
        if (!password.equals(prePassword)){
            request.getSession().setAttribute("infoPsw","输入密码错误");
            request.getRequestDispatcher("afterChangePsw.jsp").forward(request,response);
            return;
        }

        String newPassword1 = request.getParameter("newpassword1");
        String newPassword2 = request.getParameter("newpassword2");

        if (newPassword1.length() == 0 || newPassword2.length() == 0){
            request.getSession().setAttribute("infoPsw","输入的密码不能为空");
            request.getRequestDispatcher("afterChangePsw.jsp").forward(request,response);
            return;
        }

        if (!newPassword1.equals(newPassword2)){
            request.getSession().setAttribute("infoPsw","两次输入的新密码不一致");
            request.getRequestDispatcher("afterChangePsw.jsp").forward(request,response);
        }

        else {
            request.getSession().setAttribute("infoPsw","修改密码成功");
            new UserDAO().changePassword(user,newPassword1);
            request.getRequestDispatcher("afterChangePsw.jsp").forward(request,response);
        }
    }
}
