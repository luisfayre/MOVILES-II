package com.example.eva3_1_conexion_mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstVwActors;
    ArrayList<JSONObject> miListaJSON = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstVwActors = findViewById(R.id.listViewActors);

        //new MiClaseConexion().execute("http://192.168.1.254:3000/actors");
        //new MiClaseConexionOtros().execute("http://192.168.1.254:3000/actors");
        new MiClaseConexionOtros().execute("http://192.168.1.254:3000/actors/226");
    }

    class MiClaseConexion extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String sRuta = strings[0];
            String sResu = null;
            try {
                URL ruta = new URL(sRuta);
                HttpURLConnection http = (HttpURLConnection) ruta.openConnection();

                if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStreamReader inputStreamReader = new InputStreamReader(http.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    sResu = bufferedReader.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        miListaJSON.add(jsonObject);
                    }
                    lstVwActors.setAdapter(new MiAdaptador(MainActivity.this, R.layout.layout_actors, miListaJSON));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MiClaseConexionOtros extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String sRuta = strings[0];
            String sResu = null;
            try {
                URL ruta = new URL(sRuta);
                HttpURLConnection http = (HttpURLConnection) ruta.openConnection();
                //http.setRequestMethod("POST");
                //http.setRequestMethod("PUT");
                http.setRequestMethod("DELETE");
                http.setDoInput(true);
                http.setDoOutput(true);
                http.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                http.connect();

                /*JSONObject jsonObject = new JSONObject();
                jsonObject.put("first_name","Jhon");
                jsonObject.put("last_name","Smith Turkey");

                DataOutputStream dataOutputStream = new DataOutputStream(http.getOutputStream());
                dataOutputStream.write(jsonObject.toString().getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();*/

                InputStreamReader inputStreamReader = new InputStreamReader(http.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                sResu = bufferedReader.readLine();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } /*catch (JSONException e) {
                e.printStackTrace();
            }*/
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
