package us.shamenramen.patientmanager.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

//    @ManyToOne
    @Column(name = "pat_id", nullable = false)
    private long patientId;

//    @ManyToOne
    @Column(name = "doc_id", nullable = false)
    private long doctorId;

    @Column(name = "review", nullable = false, columnDefinition = "TEXT")
    @NotBlank(message="Review summary cannot be blank.")
    private String review;

    @Column(name = "rating", nullable = false)
    @NotBlank(message="Please select a rating.")
    private int rating;

    public Review() {
    }

    public Review(long pat_id, long doc_id, String review, int rating) {
        this.patientId = pat_id;
        this.doctorId = doc_id;
        this.review = review;
        this.rating = rating;
    }

    public Review(long id, long pat_id, long doc_id, String review, int rating) {
        this.id = id;
        this.patientId = pat_id;
        this.doctorId = doc_id;
        this.review = review;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPat_id() {
        return patientId;
    }

    public void setPat_id(long pat_id) {
        this.patientId = patientId;
    }

    public long getDoc_id() {
        return doctorId;
    }

    public void setDoc_id(long doc_id) {
        this.doctorId = doc_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
