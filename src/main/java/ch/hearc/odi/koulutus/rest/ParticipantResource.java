package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.services.PersistenceService;

import java.text.ParseException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("participant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public class ParticipantResource {


    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Participant> participantGet() {
        return persistenceService.getAllParticipant();
    }


    @GET
    @Path("{id}")
    public Participant getParticipantId(@PathParam("id") Long customerId) {
        try {
            return persistenceService.getParticipantById(resourceId);
        } catch (ParticipantException e) {
            e.printStackTrace();
            throw new NotFoundException("the Participant does not exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteParticipant(@PathParam("id") Long id) throws ResourceException {
        try {
            persistenceService.deleteParticipant(id);
        } catch (ParticipantException e) {
            e.printStackTrace();
            throw new ParticipantException("Participant could not be deleted");
        }
    }
}
