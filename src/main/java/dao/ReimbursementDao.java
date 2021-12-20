package dao;

import models.ReimbDTO;
import models.Reimbursement;

import java.util.List;

public interface ReimbursementDao {

    List<Reimbursement> getAllReimbs();
    List<Reimbursement> getAllReimbs(Integer userId);
    Reimbursement getOneReimb(Integer reimbId);
    void createReimb(ReimbDTO reimb);
    void updateReimb(Reimbursement reimb, Integer userId);
    void deleteReimb(Integer reimbId);
}
