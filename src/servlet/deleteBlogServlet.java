package servlet;

import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteBlogServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        new BlogDAO().deleteBlog(id);


        //为了在浏览器显示出删除以后的结果，需要再做一次数据库查询
        request.getRequestDispatcher("showMessage").forward(request,response);
    }
}
