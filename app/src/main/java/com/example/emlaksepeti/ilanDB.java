package com.example.emlaksepeti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class ilanDB extends SQLiteOpenHelper {

    ilanDB(Context context,
           String name,
           SQLiteDatabase.CursorFactory factory,
           int version){
        super(context,name,factory,version);
    }
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String il, String ilce, String semt, String tip, String oda, String m,
                           String kat, String katS, String kredi, String esya, String banyo, String yapi,
                           String kullanim, String konut, String cephe, String isinma, String  fiyat, byte []image, String mesaj){
        SQLiteDatabase  database = getWritableDatabase();
        String sql ="INSERT INTO RECORD VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,il);
        statement.bindString(2,ilce);
        statement.bindString(3,semt);
        statement.bindString(4,tip);
        statement.bindString(5,oda);
        statement.bindString(6,m);
        statement.bindString(7,kat);
        statement.bindString(8,katS);
        statement.bindString(9,kredi);
        statement.bindString(10,esya);
        statement.bindString(11,banyo);
        statement.bindString(12,yapi);
        statement.bindString(13,kullanim);
        statement.bindString(14,konut);
        statement.bindString(15,cephe);
        statement.bindString(16,isinma);
        statement.bindString(17,fiyat);
        statement.bindBlob(18, image);
        statement.bindString(19,mesaj);
        statement.executeInsert();
    }
    public void updateData(String il, String ilce, String semt, String tip, String oda, String m,
                           String kat, String katS, String kredi, String esya, String banyo, String yapi,
                           String kullanim, String konut, String cephe, String isinma, String fiyat, byte []image, int id, String mesaj){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE RECORD SET il=?, ilce=?, semt=?, tip=?, oda=?, m=?, kat=?, katS=?, kredi=?, esya=?, banyo=?, yapi=?, kullanim=?, konut=?, cephe=?, isinma=?, fiyat=?, image=?, mesaj=? WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1,il);
        statement.bindString(2,ilce);
        statement.bindString(3,semt);
        statement.bindString(4,tip);
        statement.bindString(5,oda);
        statement.bindString(6,m);
        statement.bindString(7,kat);
        statement.bindString(8,katS);
        statement.bindString(9,kredi);
        statement.bindString(10,esya);
        statement.bindString(11,banyo);
        statement.bindString(12,yapi);
        statement.bindString(13,kullanim);
        statement.bindString(14,konut);
        statement.bindString(15,cephe);
        statement.bindString(16,isinma);
        statement.bindString(17,fiyat);
        statement.bindBlob(18, image);
        statement.bindDouble(19, (double)id);
        statement.bindString(20,mesaj);

        statement.executeInsert();
        database.close();
    }
    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql ="DELETE FROM RECORD WHERE id=?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);
        statement.execute();
        statement.close();
    }
    public Cursor getData (String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertData(String trim) {
    }
}
