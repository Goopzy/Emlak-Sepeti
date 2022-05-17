package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CrediActivity extends AppCompatActivity {
    EditText para, vade;
    Button  hesapla;
    TextView sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credi);

        para=findViewById(R.id.paraGir);
        vade=findViewById(R.id.vadeGir);
        hesapla=findViewById(R.id.hesap);
        sonuc=findViewById(R.id.sonuc);
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1= Integer.parseInt(para.getText().toString());
                int s2= Integer.parseInt(vade.getText().toString());
                double sonucc=s1/s2*0.99;
                sonuc.setText(String.valueOf(sonucc));

            }
        });
    }
}