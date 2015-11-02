package com.example.kaydegroot.de_familie_yggdrasil.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kay de groot on 15-10-2015.
 */
public class YggdrasilDatabase extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Yggdrasilfamily";

    // Contacts table name
    private static final String TABLE_PERSONEN = "personen";

    // Contacts Table Columns names
    /*1*/private static final String KEY_ID = "ID";
    /*2*/private static final String KEY_roepnaam = "roepnaam";
    /*3*/private static final String KEY_geboortenaam = "geboortenaam";
    /*4*/private static final String KEY_achternaam = "achternaam";
    /*5*/private static final String KEY_tussenvoegsel = "tussenvoegsel";
    /*6*/private static final String KEY_geboortedatum = "geboortedatum";
    /*7*/private static final String KEY_overlijdinsdatum = "overlijdinsdatum";
    /*8*/private static final String KEY_generatie = "generatie";
    /*9*/private static final String KEY_ouder1ID = "ouder1ID";
    /*10*/ private static final String KEY_ouder2ID = "ouder2ID";

    public YggdrasilDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_Personen_Tabel = "CREATE TABLE " + TABLE_PERSONEN + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_roepnaam + " TEXT," +
                KEY_geboortenaam + " TEXT" + KEY_achternaam + " TEXT," +
                KEY_tussenvoegsel + " TEXT," + KEY_geboortedatum + " TEXT," +
                KEY_overlijdinsdatum + " TEXT," + KEY_generatie + " INTEGER," +
                KEY_ouder1ID + " INTEGER," + KEY_ouder2ID + " INTEGER," + ")";
        db.execSQL(create_Personen_Tabel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONEN);
        this.onCreate(db);
    }

    public void addPersoon(Persoon persoon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_roepnaam, persoon.getRoepnaam());
        values.put(KEY_geboortenaam, persoon.getGeboortenaam());
        values.put(KEY_achternaam, persoon.getAchternaam());
        values.put(KEY_tussenvoegsel, persoon.getTussenvoegsel());
        values.put(KEY_geboortedatum, persoon.getGeboortedatum().toString());
        values.put(KEY_overlijdinsdatum, persoon.getOverlijdinsdatum().toString());
        values.put(KEY_generatie, persoon.getGeneratie());
        values.put(KEY_ouder1ID, persoon.getOuder1ID());
        values.put(KEY_ouder2ID, persoon.getOuder2ID());

        db.insert(this.TABLE_PERSONEN, null, values);
        db.close();
    }

    public Persoon getPersoon(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSONEN, new String[]{KEY_ID, KEY_roepnaam, KEY_geboortenaam,
                        KEY_achternaam, KEY_tussenvoegsel, KEY_geboortedatum, KEY_overlijdinsdatum,
                        KEY_generatie, KEY_ouder1ID, KEY_ouder2ID}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Persoon persoon = new Persoon(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), new Datum(cursor.getString(5)),
                new Datum(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)));
        return persoon;
    }

    public ArrayList<Persoon> getAllePersonen() {
        ArrayList<Persoon> personen = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PERSONEN;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Persoon persoon = new Persoon(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), new Datum(cursor.getString(5)),
                        new Datum(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),
                        Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)));
            } while (cursor.moveToNext());
        }

        return personen;
    }

    public int getPersonenCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PERSONEN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updatePersonen(Persoon persoon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_roepnaam, persoon.getRoepnaam());
        values.put(KEY_geboortenaam, persoon.getGeboortenaam());
        values.put(KEY_achternaam, persoon.getAchternaam());
        values.put(KEY_tussenvoegsel, persoon.getTussenvoegsel());
        values.put(KEY_geboortedatum, persoon.getGeboortedatum().toString());
        values.put(KEY_overlijdinsdatum, persoon.getOverlijdinsdatum().toString());
        values.put(KEY_generatie, persoon.getGeneratie());
        values.put(KEY_ouder1ID, persoon.getOuder1ID());
        values.put(KEY_ouder2ID, persoon.getOuder2ID());

        // updating row
        return db.update(TABLE_PERSONEN, values, KEY_ID + " = ?",
                new String[]{String.valueOf(persoon.getID())});
    }
}
