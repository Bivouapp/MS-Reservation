package polytech.ig5.bivouapp.controllers;

import polytech.ig5.bivouapp.models.Reservation;
import polytech.ig5.bivouapp.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    // Get all reservations
    @GetMapping
    public List<Reservation> list() {
        return reservationRepository.findAll();
    }

    // Get a single reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Integer id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new reservation
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody final Reservation reservation) {
        return reservationRepository.saveAndFlush(reservation);
    }

    // Update an existing reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Integer id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            Reservation updatedReservation = reservation.get();
            updatedReservation.setStartDate(reservationDetails.getStartDate());
            updatedReservation.setEndDate(reservationDetails.getEndDate());
            updatedReservation.setNbBivouaker(reservationDetails.getNbBivouaker());
            updatedReservation.setPrice(reservationDetails.getPrice());
            updatedReservation.setStatus(reservationDetails.getStatus());
            updatedReservation.setUserId(reservationDetails.getUserId());
            updatedReservation.setBivouacId(reservationDetails.getBivouacId());
            updatedReservation.setReviewId(reservationDetails.getReviewId());
            return ResponseEntity.ok(reservationRepository.saveAndFlush(updatedReservation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
