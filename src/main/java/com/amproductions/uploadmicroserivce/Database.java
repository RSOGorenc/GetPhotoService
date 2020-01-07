package com.amproductions.uploadmicroserivce;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.json.bind.JsonbBuilder;



import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import com.kumuluz.ee.health.annotations.BuiltInHealthCheck;
import com.kumuluz.ee.health.checks.KumuluzHealthCheck;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

class Database {
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://rso-mongo-service:27017"));
    private static MongoDatabase database = mongoClient.getDatabase("imagePlatform");
    private static MongoCollection collection = database.getCollection("images");


    @SuppressWarnings("unchecked")
    static Document GetImage(ImageGetEntry entry){
        try {
            String json = JsonbBuilder.create().toJson(entry);
            BasicDBObject dbObject = BasicDBObject.parse(json);
            FindIterable result = collection.find(new org.bson.Document(dbObject.toMap()));
            Document res = null;
            for (Object doc: result) {
                res = (Document) doc;
            }
            return res;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }





}
