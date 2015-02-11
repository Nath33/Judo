package com.ingesup.project.judo.beans;

/**
 * Created by Changeform on 11/02/2015.
 */
public class Takedown {

    private int mId;
    private String mName;
    private Category mCategory;

    public Takedown() {};

    public Takedown(String name, int categoryId){
        this.mName = name;
        this.mCategory = new Category(categoryId);
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

    public Category getCategory(){
        return mCategory;
    }

    public void setCategory(Category category){
        this.mCategory = category;
    }
}
