package ModelBean;

public class PersonBean {
    private String Name;
    private String username;
    private String password;

    public PersonBean(String name, String username, String password) {
        Name = name;
        this.username = username;
        this.password = password;
    }

    public PersonBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PersonBean() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
