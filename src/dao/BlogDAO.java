package dao;

import bean.Blog;
import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    public BlogDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/microblog?characterEncoding=UTF-8",
                "root","admin");
    }

    public void insert(User user, String blogdata){
        String sql = "insert into blog values(null,?,?,null,null)";
        try(Connection c = getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);)
        {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,blogdata);

            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Blog> showAllBlog(User user){
        Blog blog = null;
        List<Blog> blogs = new ArrayList<>();
        String sql = "select * from blog where uid=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,user.getId());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setUser(user);
                blog.setBlog(rs.getString("blogdata"));
                blogs.add(blog);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blogs;
    }

    public void deleteBlog(int id){
        String sql = "delete from blog where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Blog searchBlogById(int id){
        Blog blog = null;
        String sql = "select * from blog where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                blog = new Blog();
                blog.setId(id);
                blog.setUser(new UserDAO().searchUserById(rs.getInt("uid")));
                blog.setBlog(rs.getString("blogdata"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blog;
    }

    public void commentCountPlusOne(int id){
        String sql = "select * from blog where id=?";
        String sqlUpdate = "update blog set commentcount=? where id=?";
        int count;
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);
        PreparedStatement preparedStatementPlusOne = c.prepareStatement(sqlUpdate);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("commentcount");
                count = count + 1;
                preparedStatementPlusOne.setInt(1, count);
                preparedStatementPlusOne.setInt(2,id);

                preparedStatementPlusOne.execute();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void commentCountDesOne(int id){
        String sql = "select * from blog where id=?";
        String sqlUpdate = "update blog set commentcount=? where id=?";
        int count;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);
             PreparedStatement preparedStatementDesOne = c.prepareStatement(sqlUpdate);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("commentcount");
                count = count - 1;
                preparedStatementDesOne.setInt(1, count);
                preparedStatementDesOne.setInt(2,id);

                preparedStatementDesOne.execute();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



    public List<Blog> hotBlogByComment(){
        List<Blog> blogList = new ArrayList<>();
        String sql = "select * from blog order by commentcount DESC";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setUser(new UserDAO().searchUserById(rs.getInt("uid")));
                blog.setBlog(rs.getString("blogdata"));
                blog.setCommentCount(rs.getInt("commentcount"));
                blog.setForwardCount(rs.getInt("forwardcount"));
                blogList.add(blog);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blogList;
    }




    public void forwardCountPlusOne(int id){
        String sql = "select * from blog where id=?";
        String sqlUpdate = "update blog set forwardcount=? where id=?";
        int count;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);
             PreparedStatement preparedStatementPlusOne = c.prepareStatement(sqlUpdate);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("forwardcount");
                count = count + 1;
                preparedStatementPlusOne.setInt(1, count);
                preparedStatementPlusOne.setInt(2,id);

                preparedStatementPlusOne.execute();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void forwardCountDesOne(int id){
        String sql = "select * from blog where id=?";
        String sqlUpdate = "update blog set forwardcount=? where id=?";
        int count;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);
             PreparedStatement preparedStatementDesOne = c.prepareStatement(sqlUpdate);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("forwardcount");
                count = count - 1;
                preparedStatementDesOne.setInt(1, count);
                preparedStatementDesOne.setInt(2,id);

                preparedStatementDesOne.execute();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



    public List<Blog> hotBlogByForward(){
        List<Blog> blogList = new ArrayList<>();
        String sql = "select * from blog order by forwardcount DESC";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setUser(new UserDAO().searchUserById(rs.getInt("uid")));
                blog.setBlog(rs.getString("blogdata"));
                blog.setCommentCount(rs.getInt("commentcount"));
                blog.setForwardCount(rs.getInt("forwardcount"));
                blogList.add(blog);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blogList;
    }




}

