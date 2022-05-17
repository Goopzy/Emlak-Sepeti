package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GirisActivity extends AppCompatActivity {
    private TextView username,password;
    private Button  girisBtn ;
    DbYardımcı DB;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        username =   (EditText)findViewById(R.id.username1);
        password =   (EditText)findViewById(R.id.password1);
        girisBtn    =   (Button)findViewById(R.id.girisBtn);
        DB  =   new DbYardımcı(this);

        girisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =   username.getText().toString();
                String pass =   password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(GirisActivity.this, "Lutfen butun alanlari doldurunuz", Toast.LENGTH_SHORT).show();
               else {
                   Boolean checkuserpass    =   DB.checkusernamepassword(user,pass);
                   if (checkuserpass==true){
                       Toast.makeText(GirisActivity.this, "Giris Basarili", Toast.LENGTH_SHORT).show();
                        Intent intent   =   new Intent(getApplicationContext(),AnasayfaActivity.class);
                        startActivity(intent);
                   }
                   else {
                       Toast.makeText(GirisActivity.this, "Bilgilerini Kontrol Et", Toast.LENGTH_SHORT).show();
                   }
                }

            }
        });

          }





}