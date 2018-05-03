package us.shamenramen.patientmanager.models;
import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "my_doc_id")
    private long myDocId;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private int zipcode;



//    will be applied once validation and authorization are layed out
    public User(User copy) {
        this.id = copy.id;
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
    }

    public User() {
    }

    public User(long id, String firstName, String lastName, boolean isDoctor, long myDocId, int phoneNumber, String email, String password, char gender, LocalDate dob, String street, String city, String state, int zipcode) {
        this.id = id;
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
    }


    public User(String firstName, String lastName, boolean isDoctor, long myDocId, int phoneNumber, String email, String password, char gender, LocalDate dob, String street, String city, String state, int zipcode) {
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
    }

    public long getMyDocId() {
        return myDocId;
    }

    public void setMyDocId(long myDocId) {
        this.myDocId = myDocId;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
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
        isDoctor = isDoctor;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
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
