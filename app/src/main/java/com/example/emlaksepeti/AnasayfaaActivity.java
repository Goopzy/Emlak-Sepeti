package com.example.emlaksepeti;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AnasayfaaActivity extends AppCompatActivity {
ListView liste;
ArrayList<Model>list;
ListAdapter adapter=null;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfaa);

    liste = findViewById(R.id.liste);
    list = new ArrayList<>();
    adapter = new ListAdapter(this, R.layout.row, list);
    liste.setAdapter(adapter);

        Cursor cursor = IlanEkleActivity.dbHelp.getData("SELECT * FROM RECORD");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String il=cursor.getString(1);
            String ilce=cursor.getString(2);
            String mesaj=cursor.getString(3);
            byte[]image = cursor.getBlob(4);
            list.add(new Model(id,il,ilce,mesaj,image));
        }
        adapter.notifyDataSetChanged();
        if (list.size()==0){
            Toast.makeText(this, "KAYIT Bulunamadı", Toast.LENGTH_SHORT).show();
        }
        liste.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
    }
}