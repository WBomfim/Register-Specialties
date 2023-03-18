package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.NotFoundException;
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

  /**
   * Method findAll.
   *
   */
  public List<Professional> findAll() {
    List<Professional> professionals = professionalRepository.findAll();

    if (professionals.isEmpty()) {
      throw new NotFoundException("Nenhum registro foi encontrado!");
    }

    return professionals;
  }

  /**
   * Method findById.
   *
   */
  public Optional<Professional> findById(Integer id) {
    Optional<Professional> professional = professionalRepository.findById(id);

    if (!professional.isPresent()) {
      throw new NotFoundException("Não foi encontrado nenhum registro com o ID informado");
    }

    return professional;
  }

  /**
   * Method add.
   *
   */
  public void add(Professional professional) {
    if (professional.getId() != null) {
      throw new IllegalArgumentException(
          "Não é permitido inserir novos registros com ID explícito");
    }

    professionalRepository.save(professional);
  }

  /**
   * Method update.
   *
   */
  public void update(int id, Professional professional) {
    Optional<Professional> professionalExist = professionalRepository.findById(id);

    if (!professionalExist.isPresent()) {
      throw new NotFoundException("Não é possível editar, o ID informado não existe");
    }

    professionalRepository.save(professional);
  }

  /**
   * Method delete.
   *
   */
  public void delete(Integer id) {
    Optional<Professional> professional = professionalRepository.findById(id);

    if (!professional.isPresent()) {
      throw new NotFoundException("Não é possível deletar, o ID informado não existe");
    }

    professionalRepository.deleteById(id);
  }
}
