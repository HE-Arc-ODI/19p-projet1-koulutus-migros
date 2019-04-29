package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.business.Session;
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
    return persistenceService.getPrograms();
  }

  @GET
  @Path("{programId}")
  public Program getProgram(@PathParam("programId") Long programId) {

    return persistenceService.getProgramById(programId);
  }

  @DELETE
  @Path("{programId}")
  public void deleteProgram(@PathParam("programId") Long programId) {
    persistenceService.deleteProgramById(programId);
  }

  @POST
  public Program addProgram(Program program) {
    return persistenceService.createAndPersistProgram(program);
  }

  @PUT
  @Path("{programId}")
  public Program updateProgram(@PathParam("programId") Long programId, Program program) {
    return persistenceService.updateProgramById(programId, program);
  }

  @GET
  @Path("{programId}/course")
  public List<Course> getCoursesByProgramId(@PathParam("programId") Long programId) {
    return persistenceService.getCoursesByProgramId(programId);
  }

  @POST
  @Path("{programId}/course")
  public Course addCourse(@PathParam("programId") Long programId, Course course) {
    //TODO: move in PersistenceService?
    Program program = new Program();
    program.setId(programId);
    course.setProgram(program);
    return persistenceService.createAndPersistCourse(programId, course);
  }

  @GET
  @Path("{programId}/course/{courseId}")
  public Course getCourseById(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId) {
    return persistenceService.getCourseById(programId, courseId);
  }

  @DELETE
  @Path("{programId}/course/{courseId}")
  public void deleteCourse(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId) {
    persistenceService.deleteCourse(programId, courseId);
  }

  @PUT
  @Path("{programId}/course/{courseId}")
  public Course updateCourse(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, Course course) {
    return persistenceService.updateCourse(programId, courseId, course);
  }

  @GET
  @Path("{programId}/course/{courseId}/participant")
  public List<Participant> getParticipantByCourseId(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId) {
    return persistenceService.getParticipantByCourseId(programId, courseId);
  }

  @GET
  @Path("{programId}/course/{courseId}/session")
  public List<Session> GetSessions(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId) {
    return persistenceService.getSessions(programId, courseId);
  }

  @POST
  @Path("{programId}/course/{courseId}/session")
  public List<Session> addSessions(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, List<Session> sessions) {
    return persistenceService.addSessions(programId, courseId, sessions);
  }

  @GET
  @Path("{programId}/course/{courseId}/session/{sessionId}")
  public Session getSessionById(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, @PathParam("sessionId") Long sessionId) {
    return persistenceService.getSessionById(programId, courseId, sessionId);
  }

  @DELETE
  @Path("{programId}/course/{courseId}/session/{sessionId}")
  public void deleteSessionById(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, @PathParam("sessionId") Long sessionId) {
    persistenceService.deleteSessionById(programId, courseId, sessionId);
  }

  @PUT
  @Path("{programId}/course/{courseId}/session/{sessionId}")
  public Session updateSession(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, @PathParam("sessionId") Long sessionId,
      Session session) {
    return persistenceService.updateSession(programId, courseId, sessionId, session);
  }

  @POST
  @Path("/{programId}/course/{courseId}/participant/{participantId}")
  public void registerParticipantToCourse(@PathParam("programId") Long programId,
      @PathParam("courseId") Long courseId, @PathParam("participantId") Long participantId) {
    persistenceService.registerParticipantToCourse(programId, courseId, participantId);
  }
}
