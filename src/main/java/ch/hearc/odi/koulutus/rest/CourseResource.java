package ch.hearc.odi.koulutus.rest;
import ch.hearc.odi.koulutus.business.Course;
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

@Path("resource")
@Produces(MediaType.APPLICATION_JSON)

public class CourseResource {

    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Course>CourseGet() {
        return persistenceService.getAllCourse();
    }

    @GET
    @Path("{id}")
    public Course getCourseId(@PathParam("id") Long customerId) {
        try {
            return persistenceService.getCourseById(CourseId);
        } catch (CourseException e) {
            e.printStackTrace();
            throw new NotFoundException("the Course does not exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteCourse(@PathParam("id") Long id) throws CourseException {
        try {
            persistenceService.deleteResource(id);
        } catch (ResourceException e) {
            e.printStackTrace();
            throw new CourseException("Course could not be deleted");
        }
    }
}


