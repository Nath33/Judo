package com.ingesup.project.judo.beans;

/**
 * Created by Changeform on 11/02/2015.
 */
public class Category {

    private int mId;
    private String mName;

    public Category() {};

    //Constructeur utilisé pour insérer les prises dans la base de données
    public Category(int id){
        this.mId = id;
    }

    //Constructeur utilisé pour insérer les catégories dans la base de données
    public Category(String name){
        this.mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
