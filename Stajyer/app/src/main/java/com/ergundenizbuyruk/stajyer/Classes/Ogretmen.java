package com.ergundenizbuyruk.stajyer.Classes;

import java.util.ArrayList;

public class Ogretmen {

    private String adSoyad;
    private String tcNo;
    private String ePosta;
    private String sifre;
    private ArrayList<Ogrenci> ogrencileriArrayList;

    public Ogretmen(String adSoyad, String tcNo, String ePosta, String sifre,
                   ArrayList<Ogrenci> ogrencileriArrayList) {

        this.setAdSoyad(adSoyad);
        this.setTcNo(tcNo);
        this.setePosta(ePosta);
        this.setSifre(sifre);
        if(ogrencileriArrayList == null) {
            ogrencileriArrayList = new ArrayList<>();
        }
        this.setOgrencileriArrayList(ogrencileriArrayList);
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public ArrayList<Ogrenci> getOgrencileriArrayList() {
        return ogrencileriArrayList;
    }

    public void setOgrencileriArrayList(ArrayList<Ogrenci> ogrencileriArrayList) {
        this.ogrencileriArrayList = ogrencileriArrayList;
    }
}
