package models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Reimbursement {
    Integer reimbId;
    Double reimbAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    Timestamp reimbSubmitted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    Timestamp reimbResolved;
    String reimbDesc;
    Integer reimbAuthor;
    Integer reimbResolver;
    Integer reimbStatusId;
    Integer reimbTypeId;



    public Timestamp getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(Timestamp reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Timestamp getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Timestamp reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public Reimbursement(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDesc, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatusId, Integer reimbTypeId) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDesc = reimbDesc;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    public Reimbursement() {
    }

//    public Reimbursement(Integer reimbId, Double reimbAmount, String reimbDesc, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatusId, Integer reimbTypeId) {
//        this.reimbId = reimbId;
//        this.reimbAmount = reimbAmount;
//        this.reimbDesc = reimbDesc;
//        this.reimbAuthor = reimbAuthor;
//        this.reimbResolver = reimbResolver;
//        this.reimbStatusId = reimbStatusId;
//        this.reimbTypeId = reimbTypeId;
//
//    }

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(Double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public String getReimbDesc() {
        return reimbDesc;
    }

    public void setReimbDesc(String reimbDesc) {
        this.reimbDesc = reimbDesc;
    }

    public Integer getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(Integer reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public Integer getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(Integer reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public Integer getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(Integer reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public Integer getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(Integer reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }


    @Override
    public String toString() {
        return "{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDesc='" + reimbDesc + '\'' +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbResolver=" + reimbResolver +
                ", reimbStatusId=" + reimbStatusId +
                ", reimbTypeId=" + reimbTypeId +
                '}';
    }
}
