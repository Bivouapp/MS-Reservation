package polytech.ig5.bivouapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "reservations")
@Access(AccessType.FIELD)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    private LocalDate startDate;
    private LocalDate endDate;
    private int nbBivouaker;
    private float price;
    private String status;

    @Column(name = "user_id", nullable = false)
    private int userId;  

    @Column(name = "bivouac_id", nullable = false)
    private int bivouacId; 

    @Column(name = "review_id")
    private int reviewId; 

    public int getReservationId() {
        return reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getNbBivouaker() {
        return nbBivouaker;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public int getBivouacId() {
        return bivouacId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setNbBivouaker(int nbBivouaker) {
        this.nbBivouaker = nbBivouaker;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBivouacId(int bivouacId) {
        this.bivouacId = bivouacId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
}
