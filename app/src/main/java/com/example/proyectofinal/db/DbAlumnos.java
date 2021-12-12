package com.example.proyectofinal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbAlumnos extends DbHelper{

    public static Context context;
    //Context context;

    public DbAlumnos(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public static long insertaAlumno(String matricula, String nombre, String edad, String geneo, Integer acta, Integer cartilla, Integer curp, Integer foto) {

       long id = 0;
       try {
           DbHelper dbHelper = new DbHelper(context);
           SQLiteDatabase db = dbHelper.getWritableDatabase();

           ContentValues values = new ContentValues();
           values.put("Matricula", matricula);
           values.put("Nombre", nombre);
           values.put("Edad", edad);
           values.put("Genero", geneo);
           values.put("B_Acta", acta);
           values.put("B_Cartilla", cartilla);
           values.put("B_Curp", curp);
           values.put("B_Fotos", foto);

           db.insert(TABLE_ALUMNOS, null, values);
       } catch (Exception ex){
            ex.toString();

        }

       return id;
    }
}