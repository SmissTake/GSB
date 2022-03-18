package com.example.gsb;

import android.os.AsyncTask;
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

public class MedecinDepartement extends AppCompatActivity{

    private EditText etNumDep;
    private Button btnRechMedDep;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i("TAG", "######################## onCreate: OK ########################");
        setContentView(R.layout.medecin_departement);

        btnRechMedDep = (Button) findViewById(R.id.btnRechMedDep);

        btnRechMedDep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(MedecinDepartement.this);
                String url = "http://gsb.siochaptalqper.fr/ws/lesmedecins/nom/chubilleau";
                Log.i("TAG", "######################## onClick: OK ########################");

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MedecinDepartement.this, "ça marche !!!", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MedecinDepartement.this, "ça marche pas...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
