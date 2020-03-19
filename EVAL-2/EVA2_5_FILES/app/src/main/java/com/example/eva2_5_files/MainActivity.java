package com.example.eva2_5_files;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnLeer, btnGuardar;
    final String archivo = "prueba.txt";
    final int PERMISO_ESCRITURA = 1000;
    String sRutaSD;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //AQUÍ HABRÍA QUE TOMAR DECISIONES SOBRE LOS PERMISOS
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnLeer = findViewById(R.id.btn_read);
        btnGuardar = findViewById(R.id.btn_save);

        sRutaSD = Environment.getExternalStorageDirectory().getAbsolutePath(); //Obtenemos la ruta externa
        Toast.makeText(this, sRutaSD, Toast.LENGTH_SHORT).show();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //Arreglo de permisos porque pueden ser varios permisos
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISO_ESCRITURA);
        }
    }

    public void onRead(View v) {
        try {
            //InputStream is = openFileInput(archivo); //Para memoria interna
            //Para tarjeta memoria
            FileInputStream fileInputStream = new FileInputStream(sRutaSD + "/" + archivo);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String sCade;

            try {
                while ((sCade = bufferedReader.readLine()) != null) {
                    editText.append(sCade);

                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSave(View v) {
        try {
            //OutputStream os = openFileOutput(archivo, 0); //Para memeoria interna
            //para SD
            FileOutputStream fos = new FileOutputStream(sRutaSD + "/" + archivo);
            Toast.makeText(this, sRutaSD + "/" + archivo, Toast.LENGTH_SHORT).show();
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            try {
                bw.write(editText.getText().toString());
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
