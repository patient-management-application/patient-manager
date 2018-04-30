package us.shamenramen.patientmanager.models;

public class DoctorProfile {
    private long id;
    private long user_id;
    private String biography;
    private String education;
    private String practicingField;
    private String experience;
    private String accolades;
    private String image;

    public DoctorProfile() {
    }

    public DoctorProfile(long user_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.user_id = user_id;
        this.biography = biography;
        this.education = education;
        this.practicingField = practicingField;
        this.experience = experience;
        this.accolades = accolades;
        this.image = image;
    }

    public DoctorProfile(long id, long user_id, String biography, String education, String practicingField, String experience, String accolades, String image) {
        this.id = id;
        this.user_id = user_id;
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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
