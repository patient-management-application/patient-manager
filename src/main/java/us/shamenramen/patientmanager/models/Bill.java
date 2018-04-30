package us.shamenramen.patientmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @Column(name = "transactionId", nullable = false)
    private long transactionId;

    @Column(name = "pat_id", nullable = false)
    private long pat_id;

    public Bill() {
    }

    public Bill(long pat_id) {
        this.pat_id = pat_id;
    }

    public Bill(long transactionId, long pat_id) {
        this.transactionId = transactionId;
        this.pat_id = pat_id;
    }

    public long gettransactionId() {
        return transactionId;
    }

    public void settransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getPat_id() {
        return pat_id;
    }

    public void setPat_id(long pat_id) {
        this.pat_id = pat_id;
    }
}
