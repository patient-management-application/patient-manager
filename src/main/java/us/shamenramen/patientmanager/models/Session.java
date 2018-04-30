package us.shamenramen.patientmanager.models;

import javax.persistence.*;

@Entity
@Table(name="sessions")
public class Session {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="pat_id", nullable = false)
    private long patientId;

    @Column(name="doc_id")
    private long doctorId;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "TEXT")
    private String prescriptions;

    @Column(columnDefinition = "TEXT")
    private String procedures;

    @Column(name="time_start", columnDefinition = "TEXT")
    private String timeStart;

    @Column(name="time_end")
    private String timeEnd;

    public Session() {
    }

    public Session(long patientId, long doctorId, String notes, String prescriptions, String procedures, String timeStart, String timeEnd) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.notes = notes;
        this.prescriptions = prescriptions;
        this.procedures = procedures;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Session(long id ,long patientId, long doctorId, String notes, String prescriptions, String procedures, String timeStart, String timeEnd) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.notes = notes;
        this.prescriptions = prescriptions;
        this.procedures = procedures;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
