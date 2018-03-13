package dao;

import bean.Forward;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForwardDAO {
    public ForwardDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/microblog?characterEncoding=UTF-8",
                "root","admin");
    }


    //增加转发
    public void addForward(int userId,int blogId,String forwardData){
        String sql = "insert into forward values(null,?,?,?)";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,blogId);
            preparedStatement.setString(3,forwardData);

            preparedStatement.execute();
            new BlogDAO().insert(new UserDAO().searchUserById(userId),forwardData);
            new BlogDAO().forwardCountPlusOne(blogId);
        }
        catch (SQLException e){
                 e.printStackTrace();
        }
    }

    //得到转发内容
    public List<Forward> getForward(int blogId){
        Forward forward = null;
        String sql = "select * from forward where blogId=?";
        List<Forward> list = new ArrayList<>();
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,blogId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                forward = new Forward();
                forward.setId(rs.getInt("id"));
                forward.setUser(new UserDAO().searchUserById(rs.getInt("userId")));
                forward.setBlog(new BlogDAO().searchBlogById(blogId));
                forward.setForwardData(rs.getString("forwardData"));

                list.add(forward);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public int blogId(int id){
        int blogId = 0;
        String sql = "select * from forward where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                blogId = rs.getInt("blogId");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blogId;
    }

    public void deleteForward(int id){
        new BlogDAO().forwardCountDesOne(new ForwardDAO().blogId(id));
        String sql = "delete from forward where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,id);

            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }






}
