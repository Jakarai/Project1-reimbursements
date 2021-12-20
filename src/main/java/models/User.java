package models;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;
    private Integer roleId;

    //Maybe rename vars?

    public User() {}

    public User(Integer userId, String username, String password, String firstName, String lastName, String userEmail, Integer roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public User(String username, Integer roleId, Integer userId) {
        this.username = username;
        this.roleId = roleId;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
