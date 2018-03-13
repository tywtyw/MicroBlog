package bean;

public class Forward {
    private int id;
    private User user;
    private Blog blog;
    private String forwardData;

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


    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setForwardData(String forwardData) {
        this.forwardData = forwardData;
    }

    public String getForwardData() {
        return forwardData;
    }
}

