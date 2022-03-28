package com.example.gsb;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Departement extends AppCompatActivity{

    private ListView lvListDep;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departement);

        RequestQueue queue = Volley.newRequestQueue(Departement.this);
        String url = "https://gsb.siochaptalqper.fr/ws/lesdepartements";
        Log.i("TAG", "######################## onClick: OK ########################");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Departement.this, "ça marche !!!", Toast.LENGTH_SHORT).show();//DEVELOPPEMENT

                if (response.equals("{}")) {
                    Toast.makeText(Departement.this, "Aucun médecin dans ce département", Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "################# AUCUN MEDECIN ####################");//DEVELOPPEMENT

                    Log.i("TAG", "################# LISTMEDECIN NON NULL ####################");//DEVELOPPEMENT
                    ObjectMapper mapper = new ObjectMapper();
                    try {

                        lvListDep = findViewById(R.id.lvListDep);
                        ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, response);
                        lvListDep.setAdapter(adapter);

                        System.out.println(response);

                    } catch (IOException e) {
                        Log.e("TAG",e.toString());
                    }
                }
            }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Departement.this, "ça marche pas...", Toast.LENGTH_SHORT).show();//DEVELOPPEMENT
                Log.i("TAG", error.toString());//DEVELOPPEMENT
            }
        });
        queue.add(stringRequest);
    }
}
