package us.shamenramen.patientmanager.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appointment {
//    Model for each appointment
    private long id;
    private long pat_id;
    private long doc_id;
    private DateTimeFormat scheduledTime;
    private int status_id;
    private Date dateCreated;

    public Appointment() {
    }

    public Appointment(long pat_id, long doc_id, DateTimeFormat scheduledTime, int status_id, Date dateCreated) {
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.scheduledTime = scheduledTime;
        this.status_id = status_id;
        this.dateCreated = dateCreated;
    }

    public Appointment(long id, long pat_id, long doc_id, DateTimeFormat scheduledTime, int status_id, Date dateCreated) {
        this.id = id;
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.scheduledTime = scheduledTime;
        this.status_id = status_id;
        this.dateCreated = dateCreated;
    }
}
