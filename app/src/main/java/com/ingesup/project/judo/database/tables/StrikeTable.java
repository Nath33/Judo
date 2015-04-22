package com.ingesup.project.judo.database.tables;

/**
 * Created by Changeform on 11/02/2015.
 */
public class StrikeTable {

    public static final String TABLE_NAME = "strike";

    public static final String _ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_LINK_1 = "link_1";
    public static final String COLUMN_LINK_2 = "link_2";

    public static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + _ID + " INTEGER PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_CATEGORY_ID + " INTEGER,"
                    + COLUMN_LINK_1 + " TEXT,"
                    + COLUMN_LINK_2 + " TEXT "
                    + ");";

}
