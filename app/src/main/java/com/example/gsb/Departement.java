package com.example.gsb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class Departement extends AppCompatActivity {

    private ListView lvListDep;
    private ProgressBar pbLoadDep;

    /**
     * permet de faire un appel à une API et récupère les départements dans lesquels il y à des médecins
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departement);

        lvListDep = findViewById(R.id.lvListDep);
        lvListDep.setVisibility(View.INVISIBLE);

        pbLoadDep = findViewById(R.id.pbLoadDep);

        RequestQueue queue = Volley.newRequestQueue(Departement.this);
        String url = "https://gsb.siochaptalqper.fr/ws/lesdepartements/format/json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equals("{}")) {
                            Toast.makeText(Departement.this, "Aucun Departement", Toast.LENGTH_SHORT).show();
                        } else {
                            /* si la réponse contient des éléments, création d'un nouvelle objet objectmapper */
                            ObjectMapper mapper = new ObjectMapper();
                            try {

                                ArrayList<DepartementObjet> departement = mapper.readValue(response, new TypeReference<ArrayList<DepartementObjet>>() {});

                                lvListDep = findViewById(R.id.lvListDep);
                                ArrayAdapter<DepartementObjet> adapter = new ArrayAdapter<DepartementObjet>(getBaseContext(), android.R.layout.simple_list_item_1, departement);
                                lvListDep.setAdapter(adapter);

                                pbLoadDep.setVisibility(View.INVISIBLE);
                                lvListDep.setVisibility(View.VISIBLE);

                            } catch (IOException e) {
                                Log.e("TAG", e.toString());
                                Toast.makeText(Departement.this, "une erreur est survenu, réessayer plus tard...", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }
}
