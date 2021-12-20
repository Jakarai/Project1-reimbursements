package models;

public class ReimbDTO {

     Double reimbAmount;
     String reimbDesc;
     Integer reimbAuthor;
     Integer reimbTypeId;

    public ReimbDTO(Double reimbAmount, String reimbDesc, Integer reimbAuthor, Integer reimbTypeId) {
        this.reimbAmount = reimbAmount;
        this.reimbDesc = reimbDesc;
        this.reimbAuthor = reimbAuthor;
        this.reimbTypeId = reimbTypeId;
    }

    public ReimbDTO() {
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

    public Integer getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(Integer reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    @Override
    public String toString() {
        return "{" +
                "reimbAmount=" + reimbAmount +
                ", reimbDesc='" + reimbDesc + '\'' +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbTypeId=" + reimbTypeId +
                '}';
    }
}
