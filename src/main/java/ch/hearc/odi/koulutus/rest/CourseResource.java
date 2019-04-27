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



@Path("resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public class CourseResource {

    @Inject
    private PersistenceService persistenceService;


    @GET
    public List<Resource> ResourceGet() {
        return persistenceService.getAllResources();
    }

    @GET
    @Path("{id}")
    public Resource getResourceId(@PathParam("id") Long customerId) {
        try {
            return persistenceService.getResourceById(resourceId);
        } catch (ResourceException e) {
            e.printStackTrace();
            throw new NotFoundException("the Resource does not exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteResource(@PathParam("id") Long id) throws ResourceException {
        try {
            persistenceService.deleteResource(id);
        } catch (ResourceException e) {
            e.printStackTrace();
            throw new ResourceException("Resource could not be deleted");
        }
    }
}


