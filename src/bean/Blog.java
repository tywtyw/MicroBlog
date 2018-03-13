package bean;

public class Blog {
    private int id;
    private User user;
    private String blog;
    private int commentCount;
    private int forwardCount;


/*    //fUser用户转发了forwardBlog并且转发内容是forwardData
    private User fuser;
    private Blog forwardBlog;
    private String forwardData;*/

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBlog() {
        return blog;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    /*    public void setFuser(User fuser) {
        this.fuser = fuser;
    }

    public User getFuser() {
        return fuser;
    }

    public void setForwardBlog(Blog forwardBlog) {
        this.forwardBlog = forwardBlog;
    }

    public Blog getForwardBlog() {
        return forwardBlog;
    }

    public void setForwardData(String forwardData) {
        this.forwardData = forwardData;
    }

    public String getForwardData() {
        return forwardData;
    }*/
}
