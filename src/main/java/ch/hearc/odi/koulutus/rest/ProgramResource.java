package ch.hearc.odi.koulutus.rest;


import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public class ProgramResource {


    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Program> ProgramGet() {
        return persistenceService.getAllProgram();
    }


    @GET
    @Path("{id}")
    public Program getProgramId(@PathParam("id") Long customerId) {
        try {
            return persistenceService.getProgramById(resourceId);
        } catch (ProgramException e) {
            e.printStackTrace();
            throw new NotFoundException("the Program does not exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteProgram(@PathParam("id") Long id) throws ResourceException {
        try {
            persistenceService.deletePProgram(id);
        } catch (ProgramException e) {
            e.printStackTrace();
            throw new ProgramException("Program could not be deleted");
        }
    }


}
