package com.example.darryl.bathlaunchpad;

/**
 * Created by navneet on 20/11/16.
 */

public class Data {

    private String description;
    private int id;
    private String imagePath;

    public Data(String imagePath, int id, String description) {
        this.imagePath = imagePath;
        this.id=id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getID(){
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

}
