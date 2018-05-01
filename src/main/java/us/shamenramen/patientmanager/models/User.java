package us.shamenramen.patientmanager.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
//    Model for each user
    @Id
    @Column(name = "id", columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_Doctor", nullable = false)
    private boolean isDoctor;

    @Column(name = "questionnaire_id", nullable = false)
    private long questionnaireId;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private int zipcode;

//    will be applied once validation and authorization are layed out
//    public User(User copy) {
//        this.id = copy.id;
//        this.email = copy.email;
//        this.password = copy.password;
//    }

    public User() {
    }

    public User(long id, String firstName, String lastName, boolean isDoctor, long questionnaireId, int phoneNumber, String email, String password, char gender, Date dob, String street, String city, String state, int zipcode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.questionnaireId = questionnaireId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public User(String firstName, String lastName, boolean isDoctor, long questionnaireId, int phoneNumber, String email, String password, char gender, Date dob, String street, String city, String state, int zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoctor = isDoctor;
        this.questionnaireId = questionnaireId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
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

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(long questionnaireId) {
        this.questionnaireId = questionnaireId;
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

    public int getzipcode() {
        return zipcode;
    }

    public void setzipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
