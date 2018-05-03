package us.shamenramen.patientmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @Column(name = "transaction_id", nullable = false)
    private long transactionId;

    @Column(name = "pat_id", nullable = false)
    private long patientId;

    @Column(name="status_id")
    private int statusId;

    @Column(name="amount")
    private double amount;

    @Column(name="due_by")
    private String dueBy;

    public Bill() {
    }

    public Bill(long transactionId, long patientId, int statusId, double amount, String dueBy) {
        this.transactionId = transactionId;
        this.patientId = patientId;
        this.statusId = statusId;
        this.amount = amount;
        this.dueBy = dueBy;
    }

    public Bill(long patientId, int statusId, double amount, String dueBy) {
        this.patientId = patientId;
        this.statusId = statusId;
        this.amount = amount;
        this.dueBy = dueBy;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDueBy() {
        return dueBy;
    }

    public void setDueBy(String dueBy) {
        this.dueBy = dueBy;
    }
}
