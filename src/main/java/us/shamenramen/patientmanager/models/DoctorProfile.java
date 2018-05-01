package us.shamenramen.patientmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "doctor_profiles")
public class DoctorProfile {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(name = "doc_id", nullable = false, columnDefinition = "UNSIGNED")
    private long doc_id;

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "practicing_field", nullable = false)
    private String practicingField;

    @Column(name = "experience", columnDefinition = "TEXT")
    private String experience;

    @Column(name = "accolades", columnDefinition = "TEXT")
    private String accolades;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    public DoctorProfile() {
    }

    public DoctorProfile(long doc_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.doc_id = doc_id;
        this.biography = biography;
        this.education = education;
        this.practicingField = practicingField;
        this.experience = experience;
        this.accolades = accolades;
        this.image = image;
    }

    public DoctorProfile(long id, long doc_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.id = id;
        this.doc_id = doc_id;
        this.biography = biography;
        this.education = education;
        this.practicingField = practicingField;
        this.experience = experience;
        this.accolades = accolades;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getdoc_id() {
        return doc_id;
    }

    public void setdoc_id(long doc_id) {
        this.doc_id = doc_id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPracticingField() {
        return practicingField;
    }

    public void setPracticingField(String practicingField) {
        this.practicingField = practicingField;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAccolades() {
        return accolades;
    }

    public void setAccolades(String accolades) {
        this.accolades = accolades;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
