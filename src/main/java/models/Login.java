package models;

public class Login {

    private String username;
    private String password;
    private Integer roleId;
    private Integer userId;

    public Login(String username, String password, Integer roleId, Integer userId) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.userId = userId;
    }
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Login() {}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        // maybe remove login?

        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
