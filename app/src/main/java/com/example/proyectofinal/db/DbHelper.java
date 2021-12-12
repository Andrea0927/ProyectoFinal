package com.example.proyectofinal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Alumnos";
    public static final String TABLE_ALUMNOS = "cat_alumnos";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_ALUMNOS+ " (" +
                "N_IdAlumno INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Matricula TEXT NOT NULL," +
                "Nombre TEXT NOT NULL," +
                "Edad TEXT NOT NULL," +
                "Genero TEXTT NOT NULL," +
                "B_Acta INTEGER," +
                "B_Cartilla INTEGER," +
                "B_Curp INTEGER," +
                "B_Fotos INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_ALUMNOS);
        onCreate(sqLiteDatabase);
    }
}
