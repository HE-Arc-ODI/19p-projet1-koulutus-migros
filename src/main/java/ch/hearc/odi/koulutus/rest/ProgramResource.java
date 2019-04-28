package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)

public class ProgramResource {

    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Program> ProgramGet() {
        return persistenceService.getAllProgram();
    }

    @GET
    @Path("{programId}")
    public Program getProgram(@PathParam("programId}") Long programId) {
        try {
            return persistenceService.getProgramById(programId);
        } catch (ProgramException e) {
            e.printStackTrace();
            throw new NotFoundException("the Program does not exist");
        }
    }

    @DELETE
    @Path("{programId}")
    public void deleteProgram(@PathParam("programId") Long programId) throws ResourceException {
        try {
            persistenceService.deleteProgram(programId);
        } catch (ProgramException e) {
            e.printStackTrace();
            throw new ProgramException("Program could not be deleted");
        }
    }

    @POST
    public void addProgram(Program program){

    }

    @PUT
    @Path("{programId}")
    public void updateProgram(@PathParam("programId") Long programId, Program program) throws ResourceException {
        
    }



}
