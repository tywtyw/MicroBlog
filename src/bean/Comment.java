package bean;

public class Comment {
    private int id;
    private Blog blog;
    private User uUser;
    private String comment;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setuUser(User uUser) {
        this.uUser = uUser;
    }

    public User getuUser() {
        return uUser;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
