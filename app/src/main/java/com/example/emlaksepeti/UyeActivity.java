package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UyeActivity extends AppCompatActivity {
    DbYardımcı DB;
    EditText username,password,mailGir;
    Button girisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye);

        username =   (EditText)findViewById(R.id.username);
        password =   (EditText)findViewById(R.id.password1);
        mailGir =   (EditText)findViewById(R.id.username1);
        girisBtn=   (Button)findViewById(R.id.girisBtn);
        DB = new DbYardımcı(this);


        girisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =   username.getText().toString();
                String pass =   password.getText().toString();
                String mail =   mailGir.getText().toString();

            if (user.equals("")||pass.equals("")||mail.equals(""))
                Toast.makeText(UyeActivity.this, "Lutfen butun alanlari doldurunuz", Toast.LENGTH_SHORT).show();
            else {
                if(pass.equals(pass)){
                Boolean checkuser = DB.checkusername(user);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if (insert==true){
                            Toast.makeText(UyeActivity.this, "Uyelik Islemi Basarili", Toast.LENGTH_SHORT).show();
                            Intent intent   =   new Intent(getApplicationContext(),AnasayfaActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(UyeActivity.this, "Uyelik Islemi Basarisiz", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(UyeActivity.this, "Lütfen Giriş Yap", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            }
        });

    }
}