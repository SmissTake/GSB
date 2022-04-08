package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * page d'accueil de l'application
 */
public class MainActivity extends AppCompatActivity {

    private Button btnDep;
    private Button btnMedDep;
    private Button btnNomMed;

    private void initViews(){
        btnNomMedClick();
        btnDepClick();
        btnMedDepClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void btnDepClick(){
        btnDep = (Button) findViewById(R.id.btnDep);

        btnDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Departement.class);
                startActivity(intent);
            }
        });
    }
    private void btnMedDepClick(){
        btnMedDep = (Button) findViewById(R.id.btnMedDep);

        btnMedDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MedecinDepartement.class);
                startActivity(intent);
            }
        });
    }
    private void btnNomMedClick(){
        btnNomMed = (Button) findViewById(R.id.btnNomMed);

        btnNomMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RechercheNom.class);
                startActivity(intent);
            }
        });
    }
}