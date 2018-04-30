package us.shamenramen.patientmanager.models;
import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
//    Model for each appointment

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "pat_id", nullable = false)
    private long pat_id;

    @Column(name = "doc_id", nullable = false)
    private long doc_id;

    @Column(name = "scheduledTime", nullable = false)
    private String scheduledTime;

    @Column(name = "status_id")
    private int status_id;

    @Column(name = "date_created")
    private String dateCreated;

    public Appointment() {
    }

    public Appointment(long pat_id, long doc_id, String scheduledTime, int status_id, String dateCreated) {
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.scheduledTime = scheduledTime;
        this.status_id = status_id;
        this.dateCreated = dateCreated;
    }

    public Appointment(long id, long pat_id, long doc_id, String scheduledTime, int status_id, String dateCreated) {
        this.id = id;
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.scheduledTime = scheduledTime;
        this.status_id = status_id;
        this.dateCreated = dateCreated;
    }
}
