package dao;

import bean.User;
import com.sun.javafx.css.FontFace;

import java.sql.*;

public class UserDAO {
    public UserDAO(){
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


    //查询数据库中是否已经存在该用户名
    public boolean inquire(String username){
        String sql = "select * from user where username=?";
        boolean flag = true;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                flag = true;
            }

            else {
                flag = false;
            }
        }
        catch (SQLException e){
                 e.printStackTrace();
        }
        return flag;
    }


    //将注册好的用户插入数据库
    public void insert(String name,String password){
        String sql = "insert into user values(null,?,?)";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);

            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    //根据用户名取得这个用户
    public User getUser(String name,String password){
        User user = null;
        String sql = "select * from user where username = ? and password = ?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    //修改密码
    public void changePassword(User user,String newPassword){
        String sql = "update user set password=? where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1,newPassword);
            preparedStatement.setInt(2,user.getId());

            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public User searchUser(String username){
        User user = null;
        String sql = "select * from user where username=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1,username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public User searchUserById(int id){
        User user = null;
        String sql = "select * from user where id=?";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }


}
