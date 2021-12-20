package services;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import models.ReimbDTO;
import models.Reimbursement;

import java.util.List;

public class ReimbursementService {

    ReimbursementDao reimbursementDao;

    public ReimbursementService() {
        this.reimbursementDao = new ReimbursementDaoImpl();
    }

    public ReimbursementService(ReimbursementDao reimbursementDao) {
        this.reimbursementDao = reimbursementDao;
    }
    public List<Reimbursement> getAllReimb() {
        return reimbursementDao.getAllReimbs();
    }

    public List<Reimbursement> getAllReimb(Integer userId) {
        return reimbursementDao.getAllReimbs(userId);
    }
    public Reimbursement getOneReimb(Integer userId){
        return reimbursementDao.getOneReimb(userId);
    }

    public boolean createReimb (ReimbDTO reimb){
        System.out.println(reimb);

        reimbursementDao.createReimb(reimb);
        return true;
    }

    public boolean updateReimb(Reimbursement updatedReimb, Integer userId){
        reimbursementDao.updateReimb(updatedReimb, userId);
        return true;
    }

    public void deleteReimb(Integer reimbId) {

        reimbursementDao.deleteReimb(reimbId);
    }


}
