package com.example.emlaksepeti;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;


public class IlanEkleActivity extends AppCompatActivity {
    EditText ilGir, ilceGir, semtGir, odaGir, mGir, katsGir, katGir, banyoGir, fiyatGir, mesajGir;
    Spinner tipGir, krediGir, esyaGir, yapiGir, kullanimGir, konutsGir, cepheGir, isinmaGir;
    Button gonderBtn;
    ImageView foto;
    final int REQUEST_CODE_GALLERY = 999;
    public static ilanDB dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_ekle);

        dbHelp= new ilanDB(this,"RECORD.sqlite",null,1);
        dbHelp.queryData("id INTEGER PRIMARY KEY AUTOINCREMENT, il VARCHAR, ilce VARCHAR, semt VARCHAR, tip VARCHAR, oda VARCHAR, m VARCHAR, kat VARCHAR, katS VARCHAR, kredi VARCHAR, esya VARCHAR, banyo VARCHAR, yapi VARCHAR, kullanim VARCHAR, konut VARCHAR, cephe VARCHAR, isinma VARCHAR, fiyat VARCHAR, image BLOP, mesaj VARCHAR)");




        ilGir = findViewById(R.id.ilGir);
        ilceGir = findViewById(R.id.ilceGir);
        semtGir = findViewById(R.id.semtGir);
        odaGir = findViewById(R.id.odaGir);
        mGir = findViewById(R.id.mGir);
        katsGir = findViewById(R.id.katsGir);
        katGir = findViewById(R.id.katGir);
        banyoGir = findViewById(R.id.banyoGir);
        fiyatGir = findViewById(R.id.fiyatGir);
        mesajGir = findViewById(R.id.mesajGir);
        tipGir = (Spinner) findViewById(R.id.tipGir);
        krediGir = (Spinner) findViewById(R.id.krediGir);
        esyaGir = (Spinner) findViewById(R.id.esyaGir);
        yapiGir = (Spinner) findViewById(R.id.yapiGir);
        kullanimGir = (Spinner) findViewById(R.id.kullanimGir);
        konutsGir = (Spinner) findViewById(R.id.konutsGir);
        cepheGir = (Spinner) findViewById(R.id.cepheGir);
        foto = findViewById(R.id.foto);
        gonderBtn = findViewById(R.id.gonder);
        isinmaGir = (Spinner) findViewById(R.id.isinmaGir);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.cephe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cepheGir.setAdapter(adapter);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.esya, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        esyaGir.setAdapter(adapter1);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.isinma, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        isinmaGir.setAdapter(adapter2);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.konut, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        konutsGir.setAdapter(adapter3);

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.kredi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        krediGir.setAdapter(adapter4);

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.kullanim, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kullanimGir.setAdapter(adapter5);

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this, R.array.tip, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipGir.setAdapter(adapter6);

        ArrayAdapter adapter7 = ArrayAdapter.createFromResource(this, R.array.yapi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yapiGir.setAdapter(adapter7);


        gonderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                   dbHelp.insertData(ilGir.getText().toString().trim(),
                                    ilceGir.getText().toString().trim(),
                                    semtGir.getText().toString().trim(),
                                    tipGir.getSelectedItem().toString().trim(),
                                    odaGir.getText().toString().trim(),
                                    mGir.getText().toString().trim(),
                                    katGir.getText().toString().trim(),
                                    katsGir.getText().toString().trim(),
                                    krediGir.getSelectedItem().toString().trim(),
                                    esyaGir.getSelectedItem().toString().trim(),
                                    banyoGir.getText().toString().trim(),
                                    yapiGir.getSelectedItem().toString().trim(),
                                    kullanimGir.getSelectedItem().toString().trim(),
                                    konutsGir.getSelectedItem().toString().trim(),
                                    cepheGir.getSelectedItem().toString().trim(),
                                    isinmaGir.getSelectedItem().toString().trim(),
                                    fiyatGir.getText().toString().trim(),
                                    imageViewToByte(foto),
                                    mesajGir.getText().toString().trim()

                   );
                    Toast.makeText(IlanEkleActivity.this, "Başarıyla Eklendi", Toast.LENGTH_SHORT).show();
                    ilGir.setText("");
                    ilceGir.setText("");
                    semtGir.setText("");
                    tipGir.setAdapter(adapter6);
                    odaGir.setText("");
                    mGir.setText("");
                    katGir.setText("");
                    katsGir.setText("");
                    krediGir.setAdapter(adapter4);
                    esyaGir .setAdapter(adapter1);
                    banyoGir.setText("");
                    yapiGir.setAdapter(adapter7);
                    kullanimGir.setAdapter(adapter5);
                    konutsGir.setAdapter(adapter3);
                    cepheGir.setAdapter(adapter);
                    isinmaGir.setAdapter(adapter2);
                    fiyatGir.setText("");
                    foto.setImageResource(R.drawable.addphoto);
                    mesajGir.setText("");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        gonderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IlanEkleActivity.this, AnasayfaaActivity.class));
            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(IlanEkleActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
    }

    public static byte[] imageViewToByte(ImageView foto) {

        Bitmap bitmap = ((BitmapDrawable)foto.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(this, "Dosyaya Erişim İznin Yok", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK ) {

            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (requestCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                foto.setImageURI(resultUri);
            }
            else if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
