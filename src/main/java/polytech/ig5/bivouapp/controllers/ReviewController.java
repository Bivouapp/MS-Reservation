package polytech.ig5.bivouapp.controllers;

import polytech.ig5.bivouapp.models.Review;
import polytech.ig5.bivouapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    @GetMapping
    public List<Review> list() {
        return reviewRepository.findAll();
    }

    // Get a single review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> get(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new review
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review create(@RequestBody final Review review) {
        return reviewRepository.saveAndFlush(review);
    }

    // Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            Review updatedReview = review.get();
            updatedReview.setRating(reviewDetails.getRating());
            updatedReview.setComment(reviewDetails.getComment());
            updatedReview.setDate(reviewDetails.getDate());
            return ResponseEntity.ok(reviewRepository.saveAndFlush(updatedReview));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a review by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
