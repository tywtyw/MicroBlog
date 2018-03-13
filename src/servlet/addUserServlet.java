package servlet;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addUserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        //两次密码不一样
        if (!password.equals(repassword)){
            request.getSession().setAttribute("info",s1);
            request.getRequestDispatcher("afterRegister.jsp").forward(request,response);
            return;
        }

        //在数据库中查询是否存在该用户名，存在则重新注册，不存在则注册成功。
        boolean flag = new UserDAO().inquire(username);

        if (flag){
            request.getSession().setAttribute("info",s2);
        }

        else {
            new UserDAO().insert(username,password);
            request.getSession().setAttribute("info",s3);
        }

        request.getRequestDispatcher("afterRegister.jsp").forward(request,response);



    }
}
