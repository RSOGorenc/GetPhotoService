package com.amproductions.uploadmicroserivce;

import com.mongodb.BasicDBObject;
import org.bson.BSONObject;
import org.bson.BsonArray;
import org.bson.Document;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("info")
public class InfoResource {
    @GET
    public Response getInfo() {

        Document doc = new Document();
        doc.put("clani:", "Aljaz Rupar, Marko Krajinovic");
        doc.put("opis_projekta:", "Nas projekt implementira zacetno fazo izdelave projekta za deljenje slik med uporabniki.");
        doc.append("mikrostoritve", Arrays.asList("http://104.199.9.130/v1/upload", "http://35.187.82.123/v1/catalogue/Aljaz4"));
        doc.append("github", Arrays.asList("https://github.com/RSOGorenc/UploadPhotoService", "https://github.com/RSOGorenc/GetPhotoService"));
        doc.append("travis", Arrays.asList("https://travis-ci.com/RSOGorenc/UploadPhotoService", "https://travis-ci.com/RSOGorenc/GetPhotoService"));
        doc.append("travis", Arrays.asList("https://hub.docker.com/repository/docker/aljazrupar/upload-microservice", "https://hub.docker.com/repository/docker/aljazrupar/get-microservice"));

        return Response.status(200).entity(doc.toJson()).build();
    }
}

//        "clani": ["jm1234", "mn3322"],
//        "opis_projekta": "Nas projekt implementira aplikacijo za oddajo nepremicnin.",
//        "mikrostoritve": ["http://35.189.96.118:8081/v1/orders", "http://35.197.209.159:8080/v1/customers/"],
//        "github": ["https://github.com/jmezna/rso-customers", "https://github.com/jmezna/rso-orders"],
//        "travis": ["https://travis-ci.org/jmezna/rso-customers", "https://travis-ci.org/jmezna/rso-orders"],
//        "dockerhub": ["https://hub.docker.com/r/jmezna/rso-customers/", "https://hub.docker.com/r/jmezna/rso-orders/"]
//        }