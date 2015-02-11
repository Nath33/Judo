package com.ingesup.project.judo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingesup.project.judo.beans.Category;
import com.ingesup.project.judo.beans.Takedown;
import com.ingesup.project.judo.database.tables.CategoryTable;
import com.ingesup.project.judo.database.tables.TakedownTable;

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

    /** TAKEDOWNS **/


    public long insertTakedown(SQLiteDatabase database, Takedown takedownToInsert) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TakedownTable.COLUMN_NAME, takedownToInsert.getName());
        contentValues.put(TakedownTable.COLUMN_CATEGORY_ID, takedownToInsert.getCategory().getId());

        long newRowId = database.insert(TakedownTable.TABLE_NAME, null, contentValues);

        if(newRowId == -1)
            throw new SQLException("Insertion Failed");

        return newRowId;
    }

    public List<Takedown> getAllTakedowns(){
        List<Takedown> takedowns = new ArrayList<Takedown>();

        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        Cursor cursor = db.query(TakedownTable.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Takedown takedown = new Takedown();
            takedown.setId(cursor.getInt(cursor.getColumnIndex(TakedownTable._ID)));
            takedown.setName(cursor.getString(cursor.getColumnIndex(TakedownTable.COLUMN_NAME)));
            takedown.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(TakedownTable.COLUMN_CATEGORY_ID))));
            takedowns.add(takedown);
        }

        return takedowns;
    }

    public List<Takedown> getTakedownsByCategory(int categoryId){
        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();
        List<Takedown> takedowns = new ArrayList<Takedown>();

        String whereClause = null;

        if(categoryId != -1)
            whereClause = TakedownTable.COLUMN_CATEGORY_ID + " = " + String.valueOf(categoryId);

        Cursor cursor = db.query(TakedownTable.TABLE_NAME, null, whereClause, null, null, null, null);

        while (cursor.moveToNext()) {
            Takedown takedown = new Takedown();
            takedown.setId(cursor.getInt(cursor.getColumnIndex(TakedownTable._ID)));
            takedown.setName(cursor.getString(cursor.getColumnIndex(TakedownTable.COLUMN_NAME)));
            takedown.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(TakedownTable.COLUMN_CATEGORY_ID))));

            takedowns.add(takedown);
        }

        return takedowns;
    }

    public Takedown getTakedown(int takedownId){
        SQLiteDatabase db = mDatabaseOpenHelper.getReadableDatabase();

        String whereClause = TakedownTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(takedownId) };

        Cursor cursor = db.query(TakedownTable.TABLE_NAME, null, whereClause, whereConditions, null, null, null);

        if (cursor.moveToNext()) {
            Takedown takedown = new Takedown();
            takedown.setId(cursor.getInt(cursor.getColumnIndex(TakedownTable._ID)));
            takedown.setName(cursor.getString(cursor.getColumnIndex(TakedownTable.COLUMN_NAME)));
            takedown.setCategory(getCategory(cursor.getInt(cursor.getColumnIndex(TakedownTable.COLUMN_CATEGORY_ID))));

            return takedown;
        }

        return null;
    }

    /**/

}
