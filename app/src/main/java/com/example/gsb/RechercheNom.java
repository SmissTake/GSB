package com.example.gsb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class RechercheNom extends AppCompatActivity{

    private EditText etNomMed;
    private Button btnRechNomMed;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_nom);

        btnRechNomMed = (Button) findViewById(R.id.btnRechNomMed);
        etNomMed = (EditText) findViewById(R.id.etNomMed);

        btnRechNomMed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si le champs de recherche est bien renseigné
                if(!(etNomMed.getText().toString().equals(""))){
                    RequestQueue queue = Volley.newRequestQueue(RechercheNom.this);
                    String url = "https://gsb.siochaptalqper.fr/ws/lesmedecins/format/json/nom/" + etNomMed.getText();
                    Log.i("TAG", "######################## onClick: OK ########################");

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(RechercheNom.this, "ça marche !!!", Toast.LENGTH_SHORT).show();
                                    Log.i("TAG", response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(RechercheNom.this, "ça marche pas...", Toast.LENGTH_SHORT).show();
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
