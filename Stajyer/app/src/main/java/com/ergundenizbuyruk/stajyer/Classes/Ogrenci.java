package com.ergundenizbuyruk.stajyer.Classes;

import java.util.ArrayList;

public class Ogrenci {
    private String adSoyad;
    private String tcNo;
    private String ogrenciNo;
    private String ePosta;
    private String sifre;

    public Ogrenci(String adSoyad, String tcNo, String ogrenciNo,
                   String ePosta, String sifre) {

        this.setAdSoyad(adSoyad);
        this.setTcNo(tcNo);
        this.setOgrenciNo(ogrenciNo);
        this.setePosta(ePosta);
        this.setSifre(sifre);
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

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
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

}
