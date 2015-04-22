package com.ingesup.project.judo.beans;

/**
 * Created by Changeform on 11/02/2015.
 */
public class Strike {

    private int mId;
    private String mName;
    private Category mCategory;
    private String mLink_1;
    private String mLink_2;

    public Strike() {}

    public Strike(String name, int categoryId, String link_1, String mLink_2){
        this.mName = name;
        this.mCategory = new Category(categoryId);
        this.mLink_1 = link_1;
        this.mLink_2 = mLink_2;
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

    public String getLink_1() {
            return mLink_1;
    }
    public String getLink_2() {
        return mLink_2;
    }

    public void setLink(String mLink_1, String mLink_2) {
        this.mLink_1 = mLink_1;this.mLink_2 = mLink_2;
    }
}
