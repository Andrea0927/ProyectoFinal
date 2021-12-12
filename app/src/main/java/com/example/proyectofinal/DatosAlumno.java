package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.db.DbAlumnos;

public class DatosAlumno extends AppCompatActivity {

    TextView tv_matri, tv_nombre, tv_edad, tv_documentos;
    ImageView imgGenero;
    Button btn_volver;
    String b_genero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alumno);

        tv_matri = findViewById(R.id.tv_matri);
        tv_nombre = findViewById(R.id.tv_nombre);
        tv_edad = findViewById(R.id.tv_edad);
        tv_documentos = findViewById(R.id.tv_documentos);
        imgGenero = findViewById(R.id.imgGenero);

        btn_volver = findViewById(R.id.btn_volver);

        String datosDocumentos;

        // INICIO - Captura los datos del Bundle
        Bundle bundleDestino = getIntent().getExtras(); //captura todos los datos del MainActivity

        String matriDestino = bundleDestino.getString("matri");
        String nombreDestino = bundleDestino.getString("Nombre");
        String edadDestino = bundleDestino.getString("Edad");
        String TipoGeneroDestino = bundleDestino.getString("Genero");
        String doc1Destino = bundleDestino.getString("doc1");
        String doc2Destino = bundleDestino.getString("doc2");
        String doc3Destino = bundleDestino.getString("doc3");
        String doc4Destino = bundleDestino.getString("doc4");
        String contadordoc = bundleDestino.getString("contador");
        // FIN - Captura los datos del Bundle

        datosDocumentos = doc1Destino + "\n" + doc2Destino + "\n" + doc3Destino + "\n" + doc4Destino + "\n";
        if (doc1Destino.equals("") &&  doc2Destino.equals("") &&  doc3Destino.equals("") &&  doc4Destino.equals("")) {
            datosDocumentos = "El Alumno no ha entregado ningún documento.";

        }



        // Cambia la imagen según el género
        if (TipoGeneroDestino.equals(getString(R.string.ma_Hombre))) {
            imgGenero.setImageResource(R.drawable.icon_hombrebig);
            b_genero="H";
        } else if (TipoGeneroDestino.equals(getString(R.string.ma_Mujer))) {
            imgGenero.setImageResource(R.drawable.icon_mujerbig);
            b_genero="M";
        }

        tv_matri.setText("Matrícula: " + matriDestino);
        tv_nombre.setText("Nombre de Alumno: " + nombreDestino);
        tv_edad.setText("Edad: " + edadDestino);
        tv_documentos.setText(datosDocumentos);



        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosAlumno.this, MainActivity.class);
                startActivity(intent); // pasa a la otra actividad
            }
        });



    }



}