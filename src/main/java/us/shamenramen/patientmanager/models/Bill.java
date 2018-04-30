package us.shamenramen.patientmanager.models;

public class Bill {
    private long transaction_id;
    private long pat_id;

    public Bill() {
    }

    public Bill(long pat_id) {
        this.pat_id = pat_id;
    }

    public Bill(long transaction_id, long pat_id) {
        this.transaction_id = transaction_id;
        this.pat_id = pat_id;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getPat_id() {
        return pat_id;
    }

    public void setPat_id(long pat_id) {
        this.pat_id = pat_id;
    }
}
