package us.shamenramen.patientmanager.models;
import java.util.Date;

public class User {
//    Model for each user
    private long id;
    private String firstName;
    private String lastName;
    private boolean isDoctor;
    private long questionaireId;
    private int phoneNumber;
    private String email;
    private String password;
    private char gender;
    private Date dob;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public User() {
    }

    public User(long id, String firstName, String lastName, boolean isDoctor, long questionaireId, int phoneNumber, String email, String password, char gender, Date dob, String street, String city, String state, int zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.questionaireId = questionaireId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public User(String firstName, String lastName, boolean isDoctor, long questionaireId, int phoneNumber, String email, String password, char gender, Date dob, String street, String city, String state, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.questionaireId = questionaireId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
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

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public long getQuestionaireId() {
        return questionaireId;
    }

    public void setQuestionaireId(long questionaireId) {
        this.questionaireId = questionaireId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
