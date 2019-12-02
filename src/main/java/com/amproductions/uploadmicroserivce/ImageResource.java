package com.amproductions.uploadmicroserivce;

import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("catalogue")
public class ImageResource {

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
//            String imageUrl = AwsStorage.UploadImage(image.getImageBase64());
//            ImageEntry response = new ImageEntry(imageUrl, image.getUserId(), LocalDate.now());
//            if(Database.AddImage(response)){
//                return Response.status(Response.Status.CREATED).build();
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
