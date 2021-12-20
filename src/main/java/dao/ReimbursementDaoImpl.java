package dao;

import models.ReimbDTO;
import models.Reimbursement;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {

    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(ReimbursementDaoImpl.class);

    public ReimbursementDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/jfreimbursement";
        this.username = System.getenv("AWS_RDS_USERNAME");
        this.password = System.getenv("AWS_RDS_PASSWORD");
    }

    public ReimbursementDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.logger = logger;
    }

    @Override
    public List<Reimbursement> getAllReimbs() {

        List<Reimbursement> reimbs = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ERS_REIMBURSEMENT ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getInt(9)));
            }

        } catch (SQLException e) {
            logger.error(e);
        }

        return reimbs;

    }
    @Override
    public List<Reimbursement> getAllReimbs(Integer userId) {

        List<Reimbursement> reimbs = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getInt(9)));
            }

        } catch (SQLException e) {
            logger.error(e);
        }

        System.out.println(reimbs + "allUserReimbDao");

        return reimbs;

    }

    @Override
    public Reimbursement getOneReimb(Integer reimbId) {
        Reimbursement reimbursement = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {


            String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,reimbId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getInt(9));
            }
        } catch (SQLException e) {
            logger.error(e);
        }


        return reimbursement;
    }

    @Override
    public void createReimb(ReimbDTO reimb) {


        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = " INSERT INTO ERS_REIMBURSEMENT VALUES (DEFAULT, ? , CURRENT_TIMESTAMP, NULL, ?, ?, NULL , 1 , ? );";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, reimb.getReimbAmount());
            ps.setString(2, reimb.getReimbDesc());
            ps.setInt(3, reimb.getReimbAuthor());
            ps.setInt(4, reimb.getReimbTypeId());

            ps.executeUpdate();

            System.out.println(reimb + "DAO");
        }catch (SQLException e) {
            logger.error(e);
        }

    }

    @Override
    public void updateReimb(Reimbursement reimb , Integer userId) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {


            String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = CURRENT_TIMESTAMP, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? WHERE REIMB_ID = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,reimb.getReimbStatusId());
            ps.setInt(3,reimb.getReimbId());

            System.out.println(reimb.getReimbStatusId() + "        updateDoa");
            ps.executeUpdate();

        }catch (SQLException e) {
            logger.error(e);
        }

    }

    @Override
    public void deleteReimb(Integer reimbId) {

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,reimbId);

        }catch (SQLException e) {
            logger.error(e);
        }

    }
}
