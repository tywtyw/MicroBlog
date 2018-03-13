package dao;

import bean.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    public CommentDAO(){
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


    public void addComment(int uId,int bId,String comment){
        String sql = "insert into comment values(null,?,?,?)";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,uId);
            preparedStatement.setInt(2,bId);
            preparedStatement.setString(3,comment);

            preparedStatement.execute();

            //blog表里的commentCount值加1
            new BlogDAO().commentCountPlusOne(bId);
        }
        catch (SQLException e){
                 e.printStackTrace();
        }
    }

    //查看某条微博的评论
    public List<Comment> showComment(int bId){
        List<Comment> list = new ArrayList<>();
        String sql = "select * from comment where bid=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,bId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setuUser(new UserDAO().searchUserById(rs.getInt("uid")));
                comment.setBlog(new BlogDAO().searchBlogById(rs.getInt("bid")));
                comment.setComment(rs.getString("commentdata"));

                list.add(comment);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    //根据commentId得到blogId
    public int blogId(int commentId){
        int blogId = 0;
        String sql = "select * from comment where id=?";
        try (Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setInt(1,commentId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                blogId = rs.getInt("bid");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return blogId;
    }



    //删除某条微博的评论
    public void deleteComment(int id){
        //删之前先使评论量-1
        new BlogDAO().commentCountDesOne(new CommentDAO().blogId(id));

        String sql = "delete from comment where id=?";
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
