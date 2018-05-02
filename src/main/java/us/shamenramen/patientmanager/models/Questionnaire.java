package us.shamenramen.patientmanager.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue
    private long id;

//    @ManyToOne
    @JoinColumn(name = "pat_id", nullable = false)
    private long patientId;

    @Column(name = "history", columnDefinition = "TEXT")
    private String history;

    @Column(name = "medications", columnDefinition = "TEXT")
    private String medications;

    @Column(name = "allergies", columnDefinition = "TEXT")
    @NotBlank(message="IMPORTANT:Please indicate if you DO or DO NOT have any allergies.")
    private String allergies;

    @Column(name = "extra", columnDefinition = "TEXT")
    private String extra;

    public Questionnaire() {
    }

    public Questionnaire(long id, long pat_id, String history, String medications, String allergies, String extra) {
        this.id = id;
        this.patientId = pat_id;
        this.history = history;
        this.medications = medications;
        this.allergies = allergies;
        this.extra = extra;
    }


    public Questionnaire(long pat_id, String history, String medications, String allergies, String extra) {
        this.patientId = pat_id;
        this.history = history;
        this.medications = medications;
        this.allergies = allergies;
        this.extra = extra;
    }

    public long getPat_id() {
        return patientId;
    }

    public void setPat_id(long pat_id) {
        this.patientId = pat_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
