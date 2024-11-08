package polytech.ig5.bivouapp.repositories;

import polytech.ig5.bivouapp.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
