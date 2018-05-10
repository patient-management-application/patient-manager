package us.shamenramen.patientmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "doctor_profiles")
public class DoctorProfile {


    @Id
//    @ManyToOne
    @Column(name = "doc_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long doctorId;

    @Column(name = "license_id", nullable = false, unique = true)
    private long licenseId;

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

    public DoctorProfile(long license_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.licenseId = license_id;
        this.biography = biography;
        this.education = education;
        this.practicingField = practicingField;
        this.experience = experience;
        this.accolades = accolades;
        this.image = image;
    }

    public DoctorProfile(long doc_id, long license_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.doctorId = doc_id;
        this.licenseId = license_id;
        this.biography = biography;
        this.education = education;
        this.practicingField = practicingField;
        this.experience = experience;
        this.accolades = accolades;
        this.image = image;
    }


    public long getDoctorId() { return doctorId; }

    public void setDoctorId(long doctorId) { this.doctorId = doctorId; }

    public long getLicenseId() { return licenseId; }

    public void setLicenseId(long licenseId) { this.licenseId = licenseId; }

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
