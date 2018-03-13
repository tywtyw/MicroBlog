package bean;

public class Friend {
    private int u_id;
    private int f_id;

    public void setId(int u_id,int f_id) {
        this.u_id = u_id;
        this.f_id = f_id;
    }

    public int getF_id() {
        return f_id;
    }

    public int getU_id() {
        return u_id;
    }
}
