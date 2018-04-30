package us.shamenramen.patientmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "pat_id", nullable = false)
    private long pat_id;

    @Column(name = "doc_id", nullable = false)
    private long doc_id;

    @Column(name = "review", nullable = false, columnDefinition = "TEXT")
    private String review;

    @Column(name = "rating", nullable = false)
    private int rating;

    public Review() {
    }

    public Review(long pat_id, long doc_id, String review, int rating) {
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.review = review;
        this.rating = rating;
    }

    public Review(long id, long pat_id, long doc_id, String review, int rating) {
        this.id = id;
        this.pat_id = pat_id;
        this.doc_id = doc_id;
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
        return pat_id;
    }

    public void setPat_id(long pat_id) {
        this.pat_id = pat_id;
    }

    public long getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(long doc_id) {
        this.doc_id = doc_id;
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
