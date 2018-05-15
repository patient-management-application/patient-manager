package us.shamenramen.patientmanager.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
//    Model for each user
    @Id
    @Column(name = "id", columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_Doctor")
    private boolean isDoctor;

    @Column(name = "my_doc_id")
    private long myDocId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "accolades")
    private String accolades;

    @Column(name = "biography")
    private String biography;

    @Column(name = "license_id")
    private String licenseId;

    @Column(name = "education")
    private String education;

    @Column(name = "practicing_field")
    private String practicingField;

    @Column(name = "experience")
    private String experience;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Appointment> appointments;


    public User() {
    }


    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.isDoctor = copy.isDoctor;
        this.myDocId = copy.myDocId;
        this.phoneNumber = copy.phoneNumber;
        this.email = copy.email;
        this.password = copy.password;
        this.gender = copy.gender;
        this.dob = copy.dob;
        this.street = copy.street;
        this.city = copy.city;
        this.state = copy.state;
        this.zipcode = copy.zipcode;
        this.accolades = copy.accolades;
        this.biography = copy.biography;
        this.licenseId = copy.licenseId;
        this.practicingField = copy.practicingField;
        this.experience = copy.experience;
        this.image = copy.image;
        this.education = copy.education;
    }


    public User(long id, String username, String firstName, String lastName, boolean isDoctor, long myDocId, String phoneNumber, String email, String password, String gender, String dob, String street, String city, String state, String zipcode, String accolades, String biography, String licenseId, String practicingField, String experience, String image, String education) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.myDocId = myDocId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.accolades = accolades;
        this.biography = biography;
        this.licenseId = licenseId;
        this.practicingField = practicingField;
        this.experience = experience;
        this.image = image;
        this.education = education;
    }



    public User(String username, String firstName, String lastName, boolean isDoctor, long myDocId, String phoneNumber, String email, String password, String gender, String dob, String street, String city, String state, String zipcode, String accolades, String biography, String licenseId, String practicingField, String experience, String image, String education) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.myDocId = myDocId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.accolades = accolades;
        this.biography = biography;
        this.licenseId = licenseId;
        this.practicingField = practicingField;
        this.experience = experience;
        this.image = image;
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAccolades() {
        return accolades;
    }

    public void setAccolades(String accolades) {
        this.accolades = accolades;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getMyDocId() {
        return myDocId;
    }

    public void setMyDocId(long myDocId) {
        this.myDocId = myDocId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getzipcode() {
        return zipcode;
    }

    public void setzipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
