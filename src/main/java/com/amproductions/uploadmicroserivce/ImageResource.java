package com.amproductions.uploadmicroserivce;

import org.bson.Document;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("catalogue")
public class ImageResource {


    @Counted(name = "getImage-count")
    @GET
    @Path("/{userId}")
    public Response getImage(@PathParam("userId") String userID) {
        try {
            ImageGetEntry entry = new ImageGetEntry(userID);
            Document image = Database.GetImage(entry);
            if (image == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.status(Response.Status.OK).entity(image).build();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
