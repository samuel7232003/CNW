package ModelBean;

public class UserBean extends PersonBean{
    private String userID;
    public UserBean(String userID, String Name, String username, String password) {
        super(Name, username, password);
        this.userID = userID;
    }

    public UserBean(String username, String password) {
        super(username, password);
    }

    public UserBean(String name, String username, String password) {
        super(name, username, password);
    }

    public UserBean() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
