package com.example.emlaksepeti;

public class Model {
    private int id;
    private String il;
    private String ilce;
    private String mesaj;
    private byte[] image;

    public Model(int id, String il, String ilce, String mesaj, byte[] image) {
        this.id = id;
        this.il = il;
        this.ilce = ilce;
        this.mesaj = mesaj;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
