package com.amproductions.uploadmicroserivce;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

public class ImageGetEntry {
    private String userId;

    @JsonbCreator
    public ImageGetEntry(@JsonbProperty("userId")String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }
}
