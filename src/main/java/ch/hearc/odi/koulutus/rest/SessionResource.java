package ch.hearc.odi.koulutus.rest;


import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.services.PersistenceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



@Path("session")
@Produces(MediaType.APPLICATION_JSON)

public class SessionResource {


    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Session> SessionGet() {
        return persistenceService.getAllProgram();
    }


    @GET
    @Path("{id}")
    public Program getSessionId(@PathParam("id") Long customerId) {
        try {
            return persistenceService.getSessionById(resourceId);
        } catch (SessionException e) {
            e.printStackTrace();
            throw new NotFoundException("the Session does not exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteSession(@PathParam("id") Long id) throws ResourceException {
        try {
            persistenceService.deleteProgram(id);
        } catch (SessionException e) {
            e.printStackTrace();
            throw new SessionException("Session could not be deleted");
        }
    }




}
