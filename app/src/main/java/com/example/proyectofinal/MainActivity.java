package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectofinal.db.DbAlumnos;
import com.example.proyectofinal.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    //Atributos
    EditText edt_nombre, edt_edad, edt_matri;
    RadioButton rb_hombre, rb_mujer;
    CheckBox chk_doc1, chk_doc2, chk_doc3, chk_doc4;
    Button btn_entrar;
    String matri, nombre, edad, Genero, doc1, doc2, doc3, doc4;
    Integer b_docs1, b_docs2, b_docs3, b_docs4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setear los valores
        edt_matri = findViewById(R.id.edt_matri);
        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);
        rb_hombre = findViewById(R.id.rb_hombre);
        rb_mujer = findViewById(R.id.rb_mujer);
        chk_doc1 = findViewById(R.id.chk_doc1);
        chk_doc2 = findViewById(R.id.chk_doc2);
        chk_doc3 = findViewById(R.id.chk_doc3);
        chk_doc4 = findViewById(R.id.chk_doc4);

        btn_entrar = findViewById(R.id.btn_ingresar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matri = edt_matri.getText().toString();
                nombre = edt_nombre.getText().toString();
                edad = edt_edad.getText().toString();

                if (rb_hombre.isChecked()) {
                    Genero = "Hombre";
                }
                else if (rb_mujer.isChecked()) {
                    Genero = "Mujer";
                }

                if (matri.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese Matrícula", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (nombre.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edad.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese Edad", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rb_hombre.isChecked() || rb_mujer.isChecked()) {

                }
                else {
                    Toast.makeText(MainActivity.this, "Seleccione Género", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (chk_doc1.isChecked()) {
                    doc1 = chk_doc1.getText().toString();
                    b_docs1=1;
                } else {
                    doc1 = "";
                    b_docs1=0;
                }

                if (chk_doc2.isChecked()) {
                    doc2 = chk_doc2.getText().toString();
                    b_docs2=1;
                } else {
                    doc2 = "";
                    b_docs2=0;
                }

                if (chk_doc3.isChecked()) {
                    doc3 = chk_doc3.getText().toString();
                    b_docs3=1;
                } else {
                    doc3 = "";
                    b_docs3=0;
                }

                if (chk_doc4.isChecked()) {
                    doc4 = chk_doc4.getText().toString();
                    b_docs4=1;
                } else {
                    doc4 = "";
                    b_docs4=0;
                }

                DbHelper dbhelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbhelper.getWritableDatabase();

                if (db!= null) {
                    //Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS",Toast.LENGTH_SHORT).show();
                }

                //GUARDAR EN BASE DE DATOS
                DbAlumnos dbAlumnos = new DbAlumnos(MainActivity.this);
                long id = DbAlumnos.insertaAlumno(matri, nombre, edad, Genero, b_docs1, b_docs2, b_docs3, b_docs4);

                if (id>0){
                    //Toast.makeText(MainActivity.this, "REGISTRO GUARDADO",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(MainActivity.this, "ERROR AL GUARDAR REGISTRO",Toast.LENGTH_SHORT).show();
                }



                // INICIO - pasar a otra Actividad o pantalla
                Bundle bundle = new Bundle();
                bundle.putString("Nombre", nombre);
                bundle.putString("Edad", edad);
                bundle.putString("Genero", Genero);
                bundle.putString("doc1", doc1);
                bundle.putString("doc2", doc2);
                bundle.putString("doc3", doc3);
                bundle.putString("doc4", doc4);
                bundle.putString("matri", matri);

                Intent intent = new Intent(MainActivity.this, DatosAlumno.class);
                intent.putExtras(bundle); //pasa todo los datos
                startActivity(intent); // pasa a la otra actividad
                // FIN - pasar a otra Actividad o pantalla
            }
        });
    }
}