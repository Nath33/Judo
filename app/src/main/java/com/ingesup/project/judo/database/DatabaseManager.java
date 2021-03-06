package com.ingesup.project.judo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingesup.project.judo.beans.Category;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.beans.Strikes;
import com.ingesup.project.judo.database.tables.CategoryTable;
import com.ingesup.project.judo.database.tables.StrikeTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Changeform on 11/02/2015.
 */
public class DatabaseManager {

    private static DatabaseManager _instance;
    private DatabaseOpenHelper mDatabaseOpenHelper;

    public static DatabaseManager getInstance(Context context) {
        if (_instance == null) {
            _instance = new DatabaseManager();
            _instance.init(context);
        }
        return _instance;
    }

    public void init(Context context) {
        if (mDatabaseOpenHelper == null)
            mDatabaseOpenHelper = new DatabaseOpenHelper(context);
    }

    public DatabaseOpenHelper getHelper() {
        return mDatabaseOpenHelper;
    }

    /** CATEGORIES **/

    public long insertCategory(SQLiteDatabase database, Category categoryToInsert) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CategoryTable.COLUMN_NAME, categoryToInsert.getName());

        long newRowId = database.insert(CategoryTable.TABLE_NAME, null, contentValues);

        if(newRowId == -1)
            throw new SQLException("Insertion Failed");

        return newRowId;
    }


    private List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<Category>();

        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        Cursor cursor = db.query(CategoryTable.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(CategoryTable._ID)));
            category.setName(cursor.getString(cursor.getColumnIndex(CategoryTable.COLUMN_NAME)));
            categories.add(category);
        }

        return categories;
    }

    private Category getCategory(int categoryId){
        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        String whereClause = CategoryTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(categoryId) };

        Cursor cursor = db.query(CategoryTable.TABLE_NAME, null, whereClause, whereConditions, null, null, null);

        if (cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(CategoryTable._ID)));
            category.setName(cursor.getString(cursor.getColumnIndex(CategoryTable.COLUMN_NAME)));

            return category;
        }

        return null;
    }

    /**/

    /** STRIKES **/


    public long insertStrike(SQLiteDatabase database, Strike strikeToInsert) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StrikeTable.COLUMN_NAME, strikeToInsert.getName());
        contentValues.put(StrikeTable.COLUMN_CATEGORY_ID, strikeToInsert.getCategory().getId());
        contentValues.put(StrikeTable.COLUMN_LINK_1, strikeToInsert.getLink_1());
        contentValues.put(StrikeTable.COLUMN_LINK_2, strikeToInsert.getLink_2());

        long newRowId = database.insert(StrikeTable.TABLE_NAME, null, contentValues);

        if(newRowId == -1)
            throw new SQLException("Insertion Failed");

        return newRowId;
    }

    public Strikes getAllStrikes(){
        Strikes strikes = new Strikes();

        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        Cursor cursor = db.query(StrikeTable.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Strike strike = new Strike();
            strike.setId(cursor.getInt(cursor.getColumnIndex(StrikeTable._ID)));
            strike.setName(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_NAME)));
            strike.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(StrikeTable.COLUMN_CATEGORY_ID))));
            strike.setLink(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_1)),(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_2))));
            strikes.add(strike);
        }

        cursor.close();

        return strikes;
    }

    public List<Strike> getStrikes(int categoryId){
        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();
        List<Strike> strikes = new ArrayList<Strike>();

        String whereClause = null;

        if(categoryId != -1)
            whereClause = StrikeTable.COLUMN_CATEGORY_ID + " = " + String.valueOf(categoryId);

        Cursor cursor = db.query(StrikeTable.TABLE_NAME, null, whereClause, null, null, null, null);

        while (cursor.moveToNext()) {
            Strike strike = new Strike();
            strike.setId(cursor.getInt(cursor.getColumnIndex(StrikeTable._ID)));
            strike.setName(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_NAME)));
            strike.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(StrikeTable.COLUMN_CATEGORY_ID))));
            strike.setLink(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_1)),(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_2))));

            strikes.add(strike);
        }

        return strikes;
    }

    public Strike getStrike(int strikeId){
        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        String whereClause = StrikeTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(strikeId) };

        Cursor cursor = db.query(StrikeTable.TABLE_NAME, null, whereClause, whereConditions, null, null, null);

        if (cursor.moveToNext()) {
            Strike strike = new Strike();
            strike.setId(cursor.getInt(cursor.getColumnIndex(StrikeTable._ID)));
            strike.setName(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_NAME)));
            strike.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(StrikeTable.COLUMN_CATEGORY_ID))));
            strike.setLink(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_1)),(cursor.getString(cursor.getColumnIndex(StrikeTable.COLUMN_LINK_2))));

            return strike;
        }

        return null;
    }

    /**/

}
