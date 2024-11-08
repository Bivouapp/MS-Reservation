package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "disponibility")
@Access(AccessType.FIELD)
public class Disponibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long disponibilityId;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(name = "bivouac_id", nullable = false)
    private long bivouacId;  // Remplacez Bivouac par un long pour l'identifiant

    public long getDisponibilityId() {
        return disponibilityId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getBivouacId() {
        return bivouacId;
    }

    public void setDisponibilityId(long disponibilityId) {
        this.disponibilityId = disponibilityId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setBivouacId(long bivouacId) {
        this.bivouacId = bivouacId;
    }
}
