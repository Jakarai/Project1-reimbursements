package dao;

import models.Login;
import models.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    String url;
    String usernameDbs;
    String passwordDbs;

    Logger logger = Logger.getLogger(UserDaoImpl.class);


    public UserDaoImpl() {

        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/jfreimbursement";
        this.usernameDbs = System.getenv("AWS_RDS_USERNAME");
        this.passwordDbs = System.getenv("AWS_RDS_PASSWORD");
    }

    public UserDaoImpl(String url, String username, String password) {
        this.url = url;
        this.usernameDbs = username;
        this.passwordDbs = password;
    }

    @Override
    public Login loginUser(String username, String password) {
        Login user = null;
        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)){

            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
//            System.out.println(ps + "login");
            while(rs.next()) {
                user = new Login(rs.getString(2),rs.getString(3), rs.getInt(7), rs.getInt(1));
            }
//            System.out.println(user);
        } catch (SQLException e) {
            logger.error(e);
        }

        System.out.println(user + "dao");
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)) {

            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

//            while(rs.next()) {
//                users.add(new Users(rs.get))
//            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


        return null;
    }

    @Override
    public User getOneUser(Integer userId) {
        User user = null;

        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)){

            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
        } catch (SQLException e) {
            logger.error(e);
        }


        return user;
    }

    @Override
    public void createUser(User user) {

        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)){

            String sql = "INSERT INTO ers_users VALUES (DEFAULT, ?, ?, ?, ?, ?, DEFAULT);";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getUserEmail());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
        } catch (SQLException e) {
            logger.error(e);
        }

    }

    @Override
    public User updateUser(User user) {

        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)){

            String sql = " ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
            }
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    @Override
    public void deleteUser(Integer user) {

        try (Connection conn = DriverManager.getConnection(url, usernameDbs, passwordDbs)){

            String sql = "DELETE FROM ERS_USERS WHERE ERS_USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,user);


        } catch (SQLException e) {
            logger.error(e);
        }

    }
}
