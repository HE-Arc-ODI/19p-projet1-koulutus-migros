package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.services.PersistenceService;

import java.text.ParseException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("participant")
@Produces(MediaType.APPLICATION_JSON)

public class ParticipantResource {

  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Participant> participantGet() {
    return persistenceService.getParticipants();
  }

  @GET
  @Path("{participantId}")
  public Participant getParticipantById(@PathParam("participantId") Long participantId) {
    return persistenceService.getParticipantById(participantId);
  }

  @DELETE
  @Path("{participantId}")
  public void deleteParticipant(@PathParam("participantId") Long participantId) {
    persistenceService.deleteParticipantById(participantId);
  }

  @PUT
  @Path("{participantId}")
  public Participant updateParticipant(@PathParam("participantId") Long participantId,
      Participant participant) {
    return persistenceService.updateParticipantById(participantId, participant);
  }

  @POST
  public Participant addParticipant(Participant participant) {
    return persistenceService.createAndPersistParticipant(participant);
  }

  @GET
  @Path("{participantId}/summary")
  public List<Course> getCoursesByParticipantId(@PathParam("participantId") Long participantId) {
    return persistenceService.getCoursesByParticipantId(participantId);
  }
}
