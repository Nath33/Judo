package com.ingesup.project.judo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ingesup.project.judo.beans.Category;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.database.tables.CategoryTable;
import com.ingesup.project.judo.database.tables.StrikeTable;

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
        db.execSQL(StrikeTable.TABLE_CREATE);
        db.execSQL(CategoryTable.TABLE_CREATE);

        insertCategories(db);
        insertStrikes(db);
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

    private void insertStrikes(SQLiteDatabase db){
        List<Strike> strikesToInsert = new ArrayList<Strike>();

        strikesToInsert.add(new Strike("Seoi-nage", 1));
        strikesToInsert.add(new Strike("Tai-Otoshi", 1));
        strikesToInsert.add(new Strike("Kata-guruma", 1));
        strikesToInsert.add(new Strike("Sukui-nage", 1));
        strikesToInsert.add(new Strike("Uki-Otoshi", 1));
        strikesToInsert.add(new Strike("Sumi-Otoshi", 1));
        strikesToInsert.add(new Strike("Obi-Otoshi", 1));
        strikesToInsert.add(new Strike("Seoi-Otoshi", 1));
        strikesToInsert.add(new Strike("Yama-arashi", 1));
        strikesToInsert.add(new Strike("Morote-gari", 1));
        strikesToInsert.add(new Strike("Kuchuki-taoshi", 1));
        strikesToInsert.add(new Strike("Kibisu-gaeshi", 1));
        strikesToInsert.add(new Strike("Uchi-mata-sukashi", 1));
        strikesToInsert.add(new Strike("Kouchi-gaeshi", 1));
        strikesToInsert.add(new Strike("Ippon-seoi-nage", 1));

        strikesToInsert.add(new Strike("Uki-goshi", 2));
        strikesToInsert.add(new Strike("O-goshi", 2));
        strikesToInsert.add(new Strike("Koshi-guruma", 2));
        strikesToInsert.add(new Strike("Tsurikomi-goshi", 2));
        strikesToInsert.add(new Strike("Harai-goshi", 2));
        strikesToInsert.add(new Strike("Tsuri-goshi", 2));
        strikesToInsert.add(new Strike("Hane-goshi", 2));
        strikesToInsert.add(new Strike("Utsuri-goshi", 2));
        strikesToInsert.add(new Strike("Ushiro-goshi", 2));
        strikesToInsert.add(new Strike("Daki-age", 2));
        strikesToInsert.add(new Strike("Sode-tsurikomi-goshi", 2));

        strikesToInsert.add(new Strike("Deashi-harai", 3));
        strikesToInsert.add(new Strike("Hiza-guruma", 3));
        strikesToInsert.add(new Strike("Sasae-tsurikomi-ashi", 3));
        strikesToInsert.add(new Strike("Osoto-gari", 3));
        strikesToInsert.add(new Strike("Ouchi-gari", 3));
        strikesToInsert.add(new Strike("Kosoto-gari", 3));
        strikesToInsert.add(new Strike("Kouchi-gari", 3));
        strikesToInsert.add(new Strike("Okuri-ashi-harai", 3));
        strikesToInsert.add(new Strike("Uchi-mata", 3));
        strikesToInsert.add(new Strike("Kosoto-gake", 3));
        strikesToInsert.add(new Strike("Ashi-guruma", 3));
        strikesToInsert.add(new Strike("Harai-tsurikomi-ashi", 3));
        strikesToInsert.add(new Strike("O-guruma", 3));
        strikesToInsert.add(new Strike("Osoto-guruma", 3));
        strikesToInsert.add(new Strike("Osoto-Otoshi", 3));
        strikesToInsert.add(new Strike("Tsubame-gaeshi", 3));
        strikesToInsert.add(new Strike("Osoto-gaeshi", 3));
        strikesToInsert.add(new Strike("Ouchi-gaeshi", 3));
        strikesToInsert.add(new Strike("Hane-goshi-gaeshi", 3));
        strikesToInsert.add(new Strike("Harai-goshi-gaeshi", 3));
        strikesToInsert.add(new Strike("Uchi-mata-gaeshi", 3));

        strikesToInsert.add(new Strike("Tomoe-nage", 4));
        strikesToInsert.add(new Strike("Sumi-gaeshi", 4));
        strikesToInsert.add(new Strike("Ura-nage", 4));
        strikesToInsert.add(new Strike("Hikikomi-gaeshi", 4));
        strikesToInsert.add(new Strike("Tawara-gaeshi", 4));

        strikesToInsert.add(new Strike("Yoko-Otoshi", 5));
        strikesToInsert.add(new Strike("Tani-Otoshi", 5));
        strikesToInsert.add(new Strike("Hane-makikomi", 5));
        strikesToInsert.add(new Strike("Soto-makikomi", 5));
        strikesToInsert.add(new Strike("Uki-waza", 5));
        strikesToInsert.add(new Strike("Yoko-wakare", 5));
        strikesToInsert.add(new Strike("Yoko-guruma", 5));
        strikesToInsert.add(new Strike("Yoko-gake", 5));
        strikesToInsert.add(new Strike("Daki-wakare", 5));
        strikesToInsert.add(new Strike("Uchi-makikomi", 5));
        strikesToInsert.add(new Strike("Kani-basami", 5));
        strikesToInsert.add(new Strike("Osoto-makikomi", 5));
        strikesToInsert.add(new Strike("Uchi-mata-makikomi", 5));
        strikesToInsert.add(new Strike("Harai-makikomi", 5));
        strikesToInsert.add(new Strike("Kawazu-gake", 5));

        strikesToInsert.add(new Strike("Kuzure-kesa-gatame", 6));
        strikesToInsert.add(new Strike("Kata-gatame", 6));
        strikesToInsert.add(new Strike("Kami-shibo-gatame", 6));
        strikesToInsert.add(new Strike("Kuzure-kami-shiho-gatame", 6));
        strikesToInsert.add(new Strike("Yoko-shiho-gatame", 6));
        strikesToInsert.add(new Strike("Tate-shiho-gatame", 6));
        strikesToInsert.add(new Strike("Kesa-gatame", 6));
        strikesToInsert.add(new Strike("Hon-kesa-gatame", 6));

        strikesToInsert.add(new Strike("Nami-juji-jime", 7));
        strikesToInsert.add(new Strike("Gyaku-juji-jime", 7));
        strikesToInsert.add(new Strike("Kata-juji-jime", 7));
        strikesToInsert.add(new Strike("Hadaka-jime", 7));
        strikesToInsert.add(new Strike("Okuri-eri-jime", 7));
        strikesToInsert.add(new Strike("Kata-ha-jime", 7));
        strikesToInsert.add(new Strike("Do-jime", 7));
        strikesToInsert.add(new Strike("Sode-guruma-jime", 7));
        strikesToInsert.add(new Strike("Kata-te-jime", 7));
        strikesToInsert.add(new Strike("Ryo-te-jime", 7));
        strikesToInsert.add(new Strike("Tsukkomi-jime", 7));
        strikesToInsert.add(new Strike("Sankaku-jime", 7));

        strikesToInsert.add(new Strike("Ude-garami", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-juji-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-ude-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-hiza-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-waki-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-hara-gatame", 8));
        strikesToInsert.add(new Strike("Ashi-garami", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-ashi-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-te-gatame", 8));
        strikesToInsert.add(new Strike("Ude-hishigi-sankaku-gatame", 8));

        for(Strike t : strikesToInsert){
            try {
                DatabaseManager.getInstance(mContext).insertStrike(db, t);
            } catch (SQLException ignored) {}
        }
    }
}
