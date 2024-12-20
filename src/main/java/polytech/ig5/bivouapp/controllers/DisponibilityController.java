package polytech.ig5.bivouapp.controllers;

import polytech.ig5.bivouapp.models.Disponibility;
import polytech.ig5.bivouapp.repositories.DisponibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disponibilities")
public class DisponibilityController {

    @Autowired
    private DisponibilityRepository disponibilityRepository;

    // Get all disponibilities
    @GetMapping
    public List<Disponibility> list() {
        return disponibilityRepository.findAll();
    }

    // Get a single disponibility by ID
    @GetMapping("/{id}")
    public ResponseEntity<Disponibility> get(@PathVariable Integer id) {
        Optional<Disponibility> disponibility = disponibilityRepository.findById(id);
        return disponibility.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new disponibility
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disponibility create(@RequestBody final Disponibility disponibility) {
        return disponibilityRepository.saveAndFlush(disponibility);
    }

    // Update an existing disponibility
    @PutMapping("/{id}")
    public ResponseEntity<Disponibility> update(@PathVariable Integer id, @RequestBody Disponibility disponibilityDetails) {
        Optional<Disponibility> disponibility = disponibilityRepository.findById(id);
        if (disponibility.isPresent()) {
            Disponibility updatedDisponibility = disponibility.get();
            updatedDisponibility.setStartDate(disponibilityDetails.getStartDate());
            updatedDisponibility.setEndDate(disponibilityDetails.getEndDate());
            updatedDisponibility.setBivouacId(disponibilityDetails.getBivouacId());
            return ResponseEntity.ok(disponibilityRepository.saveAndFlush(updatedDisponibility));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a disponibility by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (disponibilityRepository.existsById(id)) {
            disponibilityRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
