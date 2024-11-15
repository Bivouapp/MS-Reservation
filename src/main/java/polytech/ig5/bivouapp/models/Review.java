package polytech.ig5.bivouapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity(name = "reviews")
@Access(AccessType.FIELD)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private int rating;
    private String comment;
    private LocalDate date;

    public int getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
