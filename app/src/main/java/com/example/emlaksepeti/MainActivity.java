package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button faceBtn, varBtn, newBtn;
    public void cagir(){
        varBtn  =   (Button)findViewById(R.id.varBtn);
        newBtn  =   (Button)findViewById(R.id.newBtn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cagir();

        varBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  =   new Intent(MainActivity.this, GirisActivity.class);
                startActivity(intentLogin);
            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  =   new Intent(MainActivity.this, UyeActivity.class);
                startActivity(intentLogin);
            }
        });
    }
}