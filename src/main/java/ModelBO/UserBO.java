package ModelBO;

import ModelBean.UserBean;
import ModelDAO.UserDAO;

public class UserBO {
    UserDAO userDAO;
    public UserBO(){
        this.userDAO = new UserDAO();
    }
    public boolean signIn(String username, String password){
        UserBean user = new UserBean(username, password);
        if(userDAO.signIn(user) == false) System.out.println("user không tồn tại");
        else {
            UserBean userB = userDAO.getUserByUsername(username);
            System.out.println(userB.getName());
        }
        return true;
    }

    public boolean signUp(String name, String username, String password){
        UserBean newUser = new UserBean(name, username, password);
        return userDAO.signUp(newUser);
    }
}
