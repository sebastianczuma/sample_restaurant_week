package com.scz.restaurantweek.LayoutClassesAbout;

public class AboutObject {
    private String tytul;
    private String opis;

    public AboutObject(String tytul, String opis) {
        this.tytul = tytul;
        this.opis = opis;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}