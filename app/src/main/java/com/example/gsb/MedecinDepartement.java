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

/**
 * Activity MedecinDepartement
 *
 * Activité permettant de rechercher les médecins d'un département grâce au numéro de ce dernier
 */
public class MedecinDepartement extends AppCompatActivity{

    private EditText etNumDep;
    private Button btnRechMedDep;
    private TextView messageMedDep;
    private int numDep;
    private ListView lvResultMedDep;
    private TextView coeffLibMedDep;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medecin_departement);

        btnRechMedDep = (Button) findViewById(R.id.btnRechMedDep);
        etNumDep = (EditText) findViewById(R.id.etNumDep);
        messageMedDep = (TextView) findViewById(R.id.messageMedDep);
        coeffLibMedDep = (TextView) findViewById(R.id.coeffLibMedDep);
        coeffLibMedDep.setVisibility(View.INVISIBLE);

        btnRechMedDep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si le champs de recherche est bien renseigné
                lvResultMedDep = findViewById(R.id.lvResultMedDep);
                if(!etNumDep.getText().toString().equals("")){
                    try {
                        numDep = Integer.parseInt(etNumDep.getText().toString());

                        RequestQueue queue = Volley.newRequestQueue(MedecinDepartement.this);
                        String url = "https://gsb.siochaptalqper.fr/ws/lesmedecinsdudepartement/format/json/numdep/" + numDep;

                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    /**
                                     * Méthode s'exécutant lors de la réponse de l'API Volley
                                     *
                                     * @param response
                                     */
                                    @Override
                                    public void onResponse(String response) {
                                        if (response.equals("[]")) {
                                            coeffLibMedDep.setVisibility(View.INVISIBLE);
                                            Toast.makeText(MedecinDepartement.this, "Aucun médecin dans ce département", Toast.LENGTH_SHORT).show();
                                            messageMedDep.setText("Aucun médecin dans ce département");
                                            lvResultMedDep.setAdapter(null);

                                        } else {
                                            ObjectMapper mapper = new ObjectMapper();
                                            try {
                                                ArrayList<Medecin> medecinList = mapper.readValue(response, new TypeReference<ArrayList<Medecin>>() {});

                                                coeffLibMedDep.setVisibility(View.VISIBLE);

                                                lvResultMedDep = findViewById(R.id.lvResultMedDep);
                                                MedecinArrayAdapter adapter = new MedecinArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, medecinList);
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
                            /**
                             * Méthode s'exécutant dans le cas d'une erreur lors de la réponse de l'API Volley
                             *
                             * @param error
                             */
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MedecinDepartement.this, "une erreur est survenue, réessayer plus tard...", Toast.LENGTH_SHORT).show();
                                messageMedDep.setText("une erreur est survenue, réessayer plus tard...");

                                coeffLibMedDep.setVisibility(View.INVISIBLE);
                                Log.i("TAG", error.toString());
                                lvResultMedDep.setAdapter(null);
                            }
                        });

                        queue.add(stringRequest);
                    }
                    //If it's not an integer
                    catch (NumberFormatException e){
                        Toast.makeText(MedecinDepartement.this, "Veuillez saisir un numéro valable", Toast.LENGTH_SHORT).show();
                        messageMedDep.setText("Veuillez saisir un numéro valable");
                        lvResultMedDep.setAdapter(null);
                        coeffLibMedDep.setVisibility(View.INVISIBLE);
                        e.printStackTrace();
                    }
                }else{
                    messageMedDep.setText("Aucun numéro de département saisi");
                    Toast.makeText(MedecinDepartement.this, "Aucun numéro de département saisi", Toast.LENGTH_SHORT).show();
                    lvResultMedDep.setAdapter(null);
                    coeffLibMedDep.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
