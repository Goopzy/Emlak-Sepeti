package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class AnasayfaActivity extends AppCompatActivity {
private CardView lytProfil,lytCredit,lytAdd,lytAra;
    public void cagir(){

        lytProfil   =   (CardView)findViewById(R.id.lytProfil);
        lytCredit   =   (CardView)findViewById(R.id.lytCredit);
        lytAdd      =   (CardView)findViewById(R.id.lytAdd);
        lytAra      =   (CardView)findViewById(R.id.lytSearch);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        cagir();

        lytProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  =   new Intent(AnasayfaActivity.this, ProfilActivity.class);
                startActivity(intentLogin);
            }
        });
        lytCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  = new Intent(AnasayfaActivity.this, CrediActivity.class);
                startActivity(intentLogin);
            }
        });
        lytAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin  = new Intent(AnasayfaActivity.this, IlanEkleActivity.class);
                startActivity(intentLogin);
            }
        });
        lytAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  =   new Intent(AnasayfaActivity.this, IlanAraActivity.class);
                startActivity(intentLogin);
            }
        });
    }
}