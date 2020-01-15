package com.amproductions.uploadmicroserivce;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

class Database {
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://rso-mongo-service:27017"));
    private static MongoDatabase database = mongoClient.getDatabase("imagePlatform");
    private static MongoCollection collection = database.getCollection("images");


    @SuppressWarnings("unchecked")
    static ArrayList<Document> GetImages(String userId){
        try {

            FindIterable<Document> result = collection.find(eq("userId",userId));

            ArrayList<Document> res= new ArrayList<>();


            for (Document doc: result) {
                res.add(doc);
            }
            return res;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }





}