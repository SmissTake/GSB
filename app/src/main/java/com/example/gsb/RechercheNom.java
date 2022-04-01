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

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class RechercheNom extends AppCompatActivity{

    private EditText etNomMed;
    private Button btnRechNomMed;
    private TextView messageRechMed;

    private ListView lvResultNomMed;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_nom);

        btnRechNomMed = (Button) findViewById(R.id.btnRechNomMed);
        etNomMed = (EditText) findViewById(R.id.etNomMed);
        messageRechMed = (TextView) findViewById(R.id.messageRechNom);

        btnRechNomMed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si le champs de recherche est bien renseigné
                if(!(etNomMed.getText().toString().equals(""))){
                    RequestQueue queue = Volley.newRequestQueue(RechercheNom.this);
                    String url = "https://gsb.siochaptalqper.fr/ws/lesmedecins/format/json/nom/" + etNomMed.getText();

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    if (response.equals("[]")) {
                                        messageRechMed.setText("Aucun médecin dans ce département");

                                    } else {
                                        ObjectMapper mapper = new ObjectMapper();
                                        try {
                                            ArrayList<Medecin> medecinList = mapper.readValue(response, new TypeReference<ArrayList<Medecin>>() {});

                                            lvResultNomMed = findViewById(R.id.lvResultNomMed);
                                            MedecinArrayAdapter adapter = new MedecinArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, medecinList);
                                            lvResultNomMed.setAdapter(adapter);


                                            if (medecinList.size()>1){
                                                messageRechMed.setText(medecinList.size() + " médecins trouvés");
                                            }else {messageRechMed.setText(medecinList.size() + " médecin trouvé");}
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
                            Toast.makeText(RechercheNom.this, "une erreur est survenu, réessayer plus tard...", Toast.LENGTH_SHORT).show();
                            Log.i("TAG", error.toString());
                        }
                    });

                    queue.add(stringRequest);
                }else{
                    Toast.makeText(RechercheNom.this, "Aucun nom saisie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
