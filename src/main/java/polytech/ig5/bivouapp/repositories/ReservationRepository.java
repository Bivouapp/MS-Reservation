package polytech.ig5.bivouapp.repositories;

import polytech.ig5.bivouapp.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
