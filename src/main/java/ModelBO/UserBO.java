package ModelBO;

import ModelBean.UserBean;
import ModelDAO.UserDAO;

public class UserBO {
    static UserBean user;
    UserDAO userDAO;
    private static UserBO instance;
    public static synchronized UserBO getInstance() {
        if (instance == null) {
            instance = new UserBO();
        }
        return instance;
    }
    public UserBean getUser(){return user;}
    public void setUser(UserBean user1){user = user1;}
    public UserBO(){
        this.userDAO = new UserDAO();
    }
    public UserBean signIn(String username, String password){
        UserBean user = new UserBean(username, password);
        return userDAO.signIn(user);
    }

    public UserBean signUp(String name, String username, String password){
        UserBean newUser = new UserBean(name, username, password);
        return userDAO.signUp(newUser);
    }

    public UserBean getUserByID(String userID){
        return userDAO.getUserByID(userID);
    }
}
