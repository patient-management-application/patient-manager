package us.shamenramen.patientmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "history", columnDefinition = "TEXT")
    private String history;

    @Column(name = "medications", columnDefinition = "TEXT")
    private String medications;

    @Column(name = "allergies", columnDefinition = "TEXT")
    private String allergies;

    @Column(name = "extra", columnDefinition = "TEXT")
    private String extra;

    public Questionnaire() {
    }

    public Questionnaire(String history, String medications, String allergies, String extra) {
        this.history = history;
        this.medications = medications;
        this.allergies = allergies;
        this.extra = extra;
    }

    public Questionnaire(long id, String history, String medications, String allergies, String extra) {
        this.id = id;
        this.history = history;
        this.medications = medications;
        this.allergies = allergies;
        this.extra = extra;
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
