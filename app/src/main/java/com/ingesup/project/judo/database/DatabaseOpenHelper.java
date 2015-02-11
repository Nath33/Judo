package com.ingesup.project.judo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "judo.db";
    private static final int DATABASE_VERSION = 1;     // change whenever anything in the database changes

    private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mContext = context;
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TakedownTable.TABLE_CREATE);
        db.execSQL(CategoryTable.TABLE_CREATE);

        insertCategories(db);
        insertTakedowns(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {}

    private void insertCategories(SQLiteDatabase db){
        List<Category> categoriesToInsert = new ArrayList<Category>();

        categoriesToInsert.add(new Category("Te-waza"));
        categoriesToInsert.add(new Category("Koshi-waza"));
        categoriesToInsert.add(new Category("Ashi-waza"));
        categoriesToInsert.add(new Category("Masutemi-waza"));
        categoriesToInsert.add(new Category("Yokosutemi-waza"));
        categoriesToInsert.add(new Category("Osaekomi-waza"));
        categoriesToInsert.add(new Category("Shime-waza"));
        categoriesToInsert.add(new Category("Kansetsu-waza"));

        for(Category c : categoriesToInsert){
            try {
                DatabaseManager.getInstance(mContext).insertCategory(db, c);
            } catch (SQLException ignored) {}
        }
    }

    private void insertTakedowns(SQLiteDatabase db){
        List<Takedown> takedownsToInsert = new ArrayList<Takedown>();

        takedownsToInsert.add(new Takedown("Seoi-nage", 0));
        takedownsToInsert.add(new Takedown("Tai-Otoshi", 0));
        takedownsToInsert.add(new Takedown("Kata-guruma", 0));
        takedownsToInsert.add(new Takedown("Sukui-nage", 0));
        takedownsToInsert.add(new Takedown("Uki-Otoshi", 0));
        takedownsToInsert.add(new Takedown("Sumi-Otoshi", 0));
        takedownsToInsert.add(new Takedown("Obi-Otoshi", 0));
        takedownsToInsert.add(new Takedown("Seoi-Otoshi", 0));
        takedownsToInsert.add(new Takedown("Yama-arashi", 0));
        takedownsToInsert.add(new Takedown("Morote-gari", 0));
        takedownsToInsert.add(new Takedown("Kuchuki-taoshi", 0));
        takedownsToInsert.add(new Takedown("Kibisu-gaeshi", 0));
        takedownsToInsert.add(new Takedown("Uchi-mata-sukashi", 0));
        takedownsToInsert.add(new Takedown("Kouchi-gaeshi", 0));
        takedownsToInsert.add(new Takedown("Ippon-seoi-nage", 0));

        takedownsToInsert.add(new Takedown("Uki-goshi", 1));
        takedownsToInsert.add(new Takedown("O-goshi", 1));
        takedownsToInsert.add(new Takedown("Koshi-guruma", 1));
        takedownsToInsert.add(new Takedown("Tsurikomi-goshi", 1));
        takedownsToInsert.add(new Takedown("Harai-goshi", 1));
        takedownsToInsert.add(new Takedown("Tsuri-goshi", 1));
        takedownsToInsert.add(new Takedown("Hane-goshi", 1));
        takedownsToInsert.add(new Takedown("Utsuri-goshi", 1));
        takedownsToInsert.add(new Takedown("Ushiro-goshi", 1));
        takedownsToInsert.add(new Takedown("Daki-age", 1));
        takedownsToInsert.add(new Takedown("Sode-tsurikomi-goshi", 1));

        takedownsToInsert.add(new Takedown("Deashi-harai", 2));
        takedownsToInsert.add(new Takedown("Hiza-guruma", 2));
        takedownsToInsert.add(new Takedown("Sasae-tsurikomi-ashi", 2));
        takedownsToInsert.add(new Takedown("Osoto-gari", 2));
        takedownsToInsert.add(new Takedown("Ouchi-gari", 2));
        takedownsToInsert.add(new Takedown("Kosoto-gari", 2));
        takedownsToInsert.add(new Takedown("Kouchi-gari", 2));
        takedownsToInsert.add(new Takedown("Okuri-ashi-harai", 2));
        takedownsToInsert.add(new Takedown("Uchi-mata", 2));
        takedownsToInsert.add(new Takedown("Kosoto-gake", 2));
        takedownsToInsert.add(new Takedown("Ashi-guruma", 2));
        takedownsToInsert.add(new Takedown("Harai-tsurikomi-ashi", 2));
        takedownsToInsert.add(new Takedown("O-guruma", 2));
        takedownsToInsert.add(new Takedown("Osoto-guruma", 2));
        takedownsToInsert.add(new Takedown("Osoto-Otoshi", 2));
        takedownsToInsert.add(new Takedown("Tsubame-gaeshi", 2));
        takedownsToInsert.add(new Takedown("Osoto-gaeshi", 2));
        takedownsToInsert.add(new Takedown("Ouchi-gaeshi", 2));
        takedownsToInsert.add(new Takedown("Hane-goshi-gaeshi", 2));
        takedownsToInsert.add(new Takedown("Harai-goshi-gaeshi", 2));
        takedownsToInsert.add(new Takedown("Uchi-mata-gaeshi", 2));

        takedownsToInsert.add(new Takedown("Tomoe-nage", 3));
        takedownsToInsert.add(new Takedown("Sumi-gaeshi", 3));
        takedownsToInsert.add(new Takedown("Ura-nage", 3));
        takedownsToInsert.add(new Takedown("Hikikomi-gaeshi", 3));
        takedownsToInsert.add(new Takedown("Tawara-gaeshi", 3));

        takedownsToInsert.add(new Takedown("Yoko-Otoshi", 4));
        takedownsToInsert.add(new Takedown("Tani-Otoshi", 4));
        takedownsToInsert.add(new Takedown("Hane-makikomi", 4));
        takedownsToInsert.add(new Takedown("Soto-makikomi", 4));
        takedownsToInsert.add(new Takedown("Uki-waza", 4));
        takedownsToInsert.add(new Takedown("Yoko-wakare", 4));
        takedownsToInsert.add(new Takedown("Yoko-guruma", 4));
        takedownsToInsert.add(new Takedown("Yoko-gake", 4));
        takedownsToInsert.add(new Takedown("Daki-wakare", 4));
        takedownsToInsert.add(new Takedown("Uchi-makikomi", 4));
        takedownsToInsert.add(new Takedown("Kani-basami", 4));
        takedownsToInsert.add(new Takedown("Osoto-makikomi", 4));
        takedownsToInsert.add(new Takedown("Uchi-mata-makikomi", 4));
        takedownsToInsert.add(new Takedown("Harai-makikomi", 4));
        takedownsToInsert.add(new Takedown("Kawazu-gake", 4));

        takedownsToInsert.add(new Takedown("Kuzure-kesa-gatame", 5));
        takedownsToInsert.add(new Takedown("Kata-gatame", 5));
        takedownsToInsert.add(new Takedown("Kami-shibo-gatame", 5));
        takedownsToInsert.add(new Takedown("Kuzure-kami-shiho-gatame", 5));
        takedownsToInsert.add(new Takedown("Yoko-shiho-gatame", 5));
        takedownsToInsert.add(new Takedown("Tate-shiho-gatame", 5));
        takedownsToInsert.add(new Takedown("Kesa-gatame", 5));
        takedownsToInsert.add(new Takedown("Hon-kesa-gatame", 5));

        takedownsToInsert.add(new Takedown("Nami-juji-jime", 6));
        takedownsToInsert.add(new Takedown("Gyaku-juji-jime", 6));
        takedownsToInsert.add(new Takedown("Kata-juji-jime", 6));
        takedownsToInsert.add(new Takedown("Hadaka-jime", 6));
        takedownsToInsert.add(new Takedown("Okuri-eri-jime", 6));
        takedownsToInsert.add(new Takedown("Kata-ha-jime", 6));
        takedownsToInsert.add(new Takedown("Do-jime", 6));
        takedownsToInsert.add(new Takedown("Sode-guruma-jime", 6));
        takedownsToInsert.add(new Takedown("Kata-te-jime", 6));
        takedownsToInsert.add(new Takedown("Ryo-te-jime", 6));
        takedownsToInsert.add(new Takedown("Tsukkomi-jime", 6));
        takedownsToInsert.add(new Takedown("Sankaku-jime", 6));

        takedownsToInsert.add(new Takedown("Ude-garami", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-juji-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-ude-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-hiza-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-waki-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-hara-gatame", 7));
        takedownsToInsert.add(new Takedown("Ashi-garami", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-ashi-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-te-gatame", 7));
        takedownsToInsert.add(new Takedown("Ude-hishigi-sankaku-gatame", 7));

        for(Takedown t : takedownsToInsert){
            try {
                DatabaseManager.getInstance(mContext).insertTakedown(db, t);
            } catch (SQLException ignored) {}
        }
    }
}
