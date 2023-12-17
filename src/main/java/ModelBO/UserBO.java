package ModelBO;

import ModelBean.UserBean;
import ModelDAO.UserDAO;

public class UserBO {
    UserDAO userDAO;
    public UserBO(){
        this.userDAO = new UserDAO();
    }
    public UserBean signIn(String username, String password){
        UserBean user = new UserBean(username, password);
        return userDAO.signIn(user);
    }

    public boolean signUp(String name, String username, String password){
        UserBean newUser = new UserBean(name, username, password);
        return userDAO.signUp(newUser);
    }
}
