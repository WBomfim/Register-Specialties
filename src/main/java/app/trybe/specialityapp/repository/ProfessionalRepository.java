package app.trybe.specialityapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.trybe.specialityapp.model.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
  Optional<Professional> findById(Integer id);
}
