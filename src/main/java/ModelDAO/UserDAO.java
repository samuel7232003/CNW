package ModelDAO;

import ModelBean.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    public UserBean signIn(UserBean user){
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM user WHERE username='" + user.getUsername() + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String password = resultSet.getString("password");
                if(user.getPassword().equals(password)){
                    UserBean user_ = new UserBean(resultSet.getString("userID"), resultSet.getString("usName"), user.getUsername(), user.getPassword());
                    return user_;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public UserBean getUserByUsername(String username){
        UserBean user = null;
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM user WHERE username='" + username + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String usID = resultSet.getString("userID");
                String nameUser = resultSet.getString("usName");
                String password = resultSet.getString("password");
                user = new UserBean(usID, nameUser, nameUser, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public UserBean getUserByID(String userId){
        UserBean user = null;
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM user WHERE userID='" + userId + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String usID = resultSet.getString("userID");
                String nameUser = resultSet.getString("usName");
                String password = resultSet.getString("password");
                user = new UserBean(usID, nameUser, nameUser, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public UserBean signUp(UserBean newUser){
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM user WHERE username='" + newUser.getUsername() + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String username = resultSet.getString("username");
                if(newUser.getUsername().equals(username)){
                    return null;
                }
            }

            sql = "SELECT * FROM user ORDER BY userID DESC LIMIT 1";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            String userLastID = null;
            while(resultSet.next()){
                userLastID = resultSet.getString("userID");
                break;
            }

            if(userLastID == null) newUser.setUserID("US01");
            else{
                int numUser = Integer.parseInt(userLastID.substring(2));
                String ID_newUser = "US";
                numUser++;
                if(numUser < 10) ID_newUser += "0" + numUser;
                else ID_newUser += numUser;
                newUser.setUserID(ID_newUser);
            }
            sql = "INSERT INTO user(userID, usName, username, password) VALUES ('" + newUser.getUserID() + "'," +
                    "'" + newUser.getName() + "'" +
                    ",'" + newUser.getUsername() + "'," +
                    "'" + newUser.getPassword() + "')";
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getUserByUsername(newUser.getUsername());
    }
}
