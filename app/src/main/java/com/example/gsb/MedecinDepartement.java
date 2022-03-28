package com.example.gsb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedecinDepartement extends AppCompatActivity{

    private EditText etNumDep;
    private Button btnRechMedDep;
    private TextView messageMedDep;
    private int numDep;
    private ListView lvResultMedDep;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medecin_departement);

        btnRechMedDep = (Button) findViewById(R.id.btnRechMedDep);
        etNumDep = (EditText) findViewById(R.id.etNumDep);
        messageMedDep = (TextView) findViewById(R.id.messageMedDep);
        btnRechMedDep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si le champs de recherche est bien renseigné
                if(!etNumDep.getText().toString().equals("")){
                    try {
                        numDep = Integer.parseInt(etNumDep.getText().toString());

                        RequestQueue queue = Volley.newRequestQueue(MedecinDepartement.this);
                        String url = "https://gsb.siochaptalqper.fr/ws/lesmedecinsdudepartement/format/json/numdep/" + numDep;
                        Log.i("TAG", "######################## onClick: OK ########################");

                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Toast.makeText(MedecinDepartement.this, "ça marche !!!", Toast.LENGTH_SHORT).show();//DEVELOPPEMENT

                                        if (response.equals("{}")) {
                                            Toast.makeText(MedecinDepartement.this, "Aucun médecin dans ce département", Toast.LENGTH_SHORT).show();
                                            messageMedDep.setText("Aucun médecin dans ce département");
                                            Log.i("TAG", "################# AUCUN MEDECIN ####################");//DEVELOPPEMENT

                                        } else {
                                            Log.i("TAG", "################# LISTMEDECIN NON NULL ####################");//DEVELOPPEMENT
                                            ObjectMapper mapper = new ObjectMapper();
                                            try {
                                                ArrayList<Medecin> medecinList = mapper.readValue(response, new TypeReference<ArrayList<Medecin>>() {});

                                                lvResultMedDep = findViewById(R.id.lvResultMedDep);
                                                ArrayAdapter<Medecin> adapter = new ArrayAdapter<Medecin>(getBaseContext(), android.R.layout.simple_list_item_1, medecinList);
                                                lvResultMedDep.setAdapter(adapter);


                                                if (medecinList.size()>1){
                                                    messageMedDep.setText(medecinList.size() + " médecins trouvés");
                                                }else {messageMedDep.setText(medecinList.size() + " médecin trouvé");}
                                                System.out.println(medecinList);

                                                for(Medecin medecin : medecinList) {
                                                    System.out.println(medecin.getNom());
                                                }

                                            } catch (IOException e) {
                                                Log.e("TAG",e.toString());
                                            }

                                        }
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                messageMedDep.setText("Aucun médecin dans ce département");
                                Toast.makeText(MedecinDepartement.this, "ça marche pas...", Toast.LENGTH_SHORT).show();//DEVELOPPEMENT
                                Log.i("TAG", error.toString());//DEVELOPPEMENT
                            }
                        });

                        queue.add(stringRequest);
                    }
                    //If it's not an integer
                    catch (NumberFormatException e){
                        Log.e("TAG", "######################## NOT AN INT ########################");
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(MedecinDepartement.this, "Aucun numéro de département saisie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
