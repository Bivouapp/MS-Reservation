package polytech.ig5.bivouapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "disponibility")
@Access(AccessType.FIELD)
public class Disponibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disponibilityId;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(name = "bivouac_id", nullable = false)
    private int bivouacId;

    public int getDisponibilityId() {
        return disponibilityId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getBivouacId() {
        return bivouacId;
    }

    public void setDisponibilityId(int disponibilityId) {
        this.disponibilityId = disponibilityId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setBivouacId(int bivouacId) {
        this.bivouacId = bivouacId;
    }
}
