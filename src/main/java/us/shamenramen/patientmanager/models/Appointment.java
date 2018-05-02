package us.shamenramen.patientmanager.models;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
//    Model for each appointment

    @Id
    @GeneratedValue
    private long id;


    @Column(name = "pat_id", nullable = false)
    private long patientId;

    @Column(name = "doc_id", nullable = false)
    private long doctorId;

    @Column(name = "scheduled_time", nullable = false, columnDefinition = "datetime")
    @NotBlank(message="scheduled time cannot be blank.")
    private String scheduledTime;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "date_created", columnDefinition = "datetime")
    private String dateCreated;

    public Appointment() {
    }

    public Appointment(long patientId, long doctor_id, String scheduledTime, int status_id, String dateCreated) {
        this.patientId = patientId;
        this.doctorId = doctor_id;
        this.scheduledTime = scheduledTime;
        this.statusId = status_id;
        this.dateCreated = dateCreated;
    }

    public Appointment(long id,long pat_id, long doctor_id, String scheduledTime, int status_id, String dateCreated) {
        this.id  = id;
        this.patientId = pat_id;
        this.doctorId = doctor_id;
        this.scheduledTime = scheduledTime;
        this.statusId = status_id;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() { return patientId; }

    public void setPatientId(long patientId) { this.patientId = patientId; }

    public long getDoctorId() { return doctorId; }

    public void setDoctorId(long doctorId) { this.doctorId = doctorId; }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getStatusId() { return statusId; }

    public void setStatusId(int statusId) { this.statusId = statusId; }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }
}
