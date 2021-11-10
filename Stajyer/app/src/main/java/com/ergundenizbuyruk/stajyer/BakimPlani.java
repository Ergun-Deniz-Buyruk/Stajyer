package com.ergundenizbuyruk.stajyer;

public class BakimPlani {
    private String hastaAdi;
    private String hastaCinsiyet;
    private String hastaMedeniDurum;
    private String hastaMeslegi;
    private String hastaYatisTarihi;
    private String hastaGeldigiYer;
    private String hastaTibbiTani;
    private String hastaYas;

    public BakimPlani(String hastaAdi, String hastaCinsiyet, String hastaMedeniDurum,
                      String hastaMeslegi, String hastaYatisTarihi,
                      String hastaGeldigiYer, String hastaTibbiTani,
                      String hastaYas) {
        this.setHastaAdi(hastaAdi);
        this.setHastaCinsiyet(hastaCinsiyet);
        this.setHastaMedeniDurum(hastaMedeniDurum);
        this.setHastaYatisTarihi(hastaYatisTarihi);
        this.setHastaMeslegi(hastaMeslegi);
        this.setHastaGeldigiYer(hastaGeldigiYer);
        this.setHastaTibbiTani(hastaTibbiTani);
        this.setHastaYas(hastaYas);
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }


    public String getHastaCinsiyet() {
        return hastaCinsiyet;
    }

    public void setHastaCinsiyet(String hastaCinsiyet) {
        this.hastaCinsiyet = hastaCinsiyet;
    }

    public String getHastaMedeniDurum() {
        return hastaMedeniDurum;
    }

    public void setHastaMedeniDurum(String hastaMedeniDurum) {
        this.hastaMedeniDurum = hastaMedeniDurum;
    }

    public String getHastaMeslegi() {
        return hastaMeslegi;
    }

    public void setHastaMeslegi(String hastaMeslegi) {
        this.hastaMeslegi = hastaMeslegi;
    }

    public String getHastaYatisTarihi() {
        return hastaYatisTarihi;
    }

    public void setHastaYatisTarihi(String hastaYatisTarihi) {
        this.hastaYatisTarihi = hastaYatisTarihi;
    }

    public String getHastaGeldigiYer() {
        return hastaGeldigiYer;
    }

    public void setHastaGeldigiYer(String hastaGeldigiYer) {
        this.hastaGeldigiYer = hastaGeldigiYer;
    }

    public String getHastaTibbiTani() {
        return hastaTibbiTani;
    }

    public void setHastaTibbiTani(String hastaTibbiTani) {
        this.hastaTibbiTani = hastaTibbiTani;
    }

    public String getHastaYas() {
        return hastaYas;
    }

    public void setHastaYas(String hastaYas) {
        this.hastaYas = hastaYas;
    }

    @Override
    public String toString() {
        return "BakimPlani{" +
                "hastaAdi='" + hastaAdi + '\'' +
                ", hastaCinsiyet='" + hastaCinsiyet + '\'' +
                ", hastaMedeniDurum='" + hastaMedeniDurum + '\'' +
                ", hastaMeslegi='" + hastaMeslegi + '\'' +
                ", hastaYatisTarihi='" + hastaYatisTarihi + '\'' +
                ", hastaGeldigiYer='" + hastaGeldigiYer + '\'' +
                ", hastaTibbiTani='" + hastaTibbiTani + '\'' +
                ", hastaYas='" + hastaYas + '\'' +
                '}';
    }
}
