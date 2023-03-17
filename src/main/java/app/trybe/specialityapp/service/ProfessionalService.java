package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service ProfessionalService.
 *
 */
@Service
public class ProfessionalService {
  @Autowired
  private ProfessionalRepository professionalRepository;

  public List<Professional> findAll() {
    System.out.println("AQUIIIIIIIIIIIIIIIIIIIII: ");
    return professionalRepository.findAll();
  }

  public Professional findById(Integer id) {
    return professionalRepository.findById(id).get();
  }

  public Professional add(Professional professional) {
    return professionalRepository.save(professional);
  }

  public Professional update(Professional professional) {
    return professionalRepository.save(professional);
  }

  public void delete(Integer id) {
    professionalRepository.deleteById(id);
  }
}
