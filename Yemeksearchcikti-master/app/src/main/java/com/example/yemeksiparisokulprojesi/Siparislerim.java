package com.example.yemeksiparisokulprojesi;

public class Siparislerim {

    String food,fiyat,aciklama,adres;

    public Siparislerim(String food, String fiyat, String aciklama, String adres) {
        this.food = food;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
        this.adres = adres;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
