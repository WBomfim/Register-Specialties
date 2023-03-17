package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

/**
 * Controller ProfessionalController.
 *
 */
@Controller
@Path("/professional")
public class ProfessionalController {
  @Inject
  private ProfessionalService professionalService;

  /**
   * Method findAll.
   */
  @GET
  @Path("/all")
  @Produces("application/json")
  public Response findAll() {
    List<Professional> professionals = professionalService.findAll();
    return Response.ok(professionals).build();
  }

  /**
   * Method findById.
   */
  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response findById(@PathParam("id") Integer id) {
    Professional professional = professionalService.findById(id);
    return Response.ok(professional).build();
  }

  /**
   * Method add.
   */
  @POST
  @Path("/add")
  @Produces("application/json")
  public Response add(Professional professional) {
    professionalService.add(professional);
    return Response.status(Response.Status.CREATED).entity("Inserido").build();
  }

  /**
   * Method update.
   */
  @PUT
  @Path("/edit/{id}")
  public Response update(@PathParam("id") Integer id, Professional professional) {
    professional.setId(id);
    professionalService.update(professional);
    return Response.ok(String.format("ID [%d] atualizado", id)).build();
  }

  /**
   * Method delete.
   */
  @DELETE
  @Path("/delete/{id}")
  public Response delete(@PathParam("id") Integer id) {
    professionalService.delete(id);
    return Response.ok(String.format("ID [%d] removido", id)).build();
  }

}
