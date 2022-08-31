package com.example.shivamapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "dbStudents" ;

    public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "";

        query = "CREATE TABLE\n" +
                "  tblstudents(\n" +
                "     tRollNo Text,\n" +
                "     tFirstName Text,\n" +
                "     tMiddleName Text,\n" +
                "     tLastName Text\n" +
                ")";

        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {

    }
}
