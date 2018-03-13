package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
    public FriendDAO(){
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

    public void SetFollow(int u_id,int f_id){
        String sql = "insert into friend values(?,?)";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,u_id);
            preparedStatement.setInt(2,f_id);

            preparedStatement.execute();
        }
        catch (SQLException e){
                 e.printStackTrace();
        }

    }

    public boolean checkFollow(int u_id,int f_id){
        boolean flag = false;
        String sql = "select * from friend where u_id=? and f_id=?";
        try(Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,u_id);
            preparedStatement.setInt(2, f_id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                flag = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }


    public void unFollow(int uId,int fId){
        String sql = "delete from friend where u_id=? and f_id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,uId);
            preparedStatement.setInt(2,fId);

            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> showFollower(int uId){
        String sql = "select * from friend where u_id=?";
        List<User> userList = new ArrayList<>();
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql)){
         preparedStatement.setInt(1,uId);

         ResultSet rs = preparedStatement.executeQuery();

         while (rs.next()){
             int id = rs.getInt("f_id");
             User user = new UserDAO().searchUserById(id);
             userList.add(user);
         }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public List<User> showFan(int fId){
        String sql = "select * from friend where f_id=?";
        List<User> userList = new ArrayList<>();
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql)){
            preparedStatement.setInt(1,fId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("u_id");
                User user = new UserDAO().searchUserById(id);
                userList.add(user);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }
}
