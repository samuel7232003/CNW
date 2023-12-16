package ModelBean;

public class UserBean extends PersonBean{
    private String userID;
    public UserBean(String userID, String Name, String username, String password) {
        super(Name, username, password);
        this.userID = userID;
    }
}
