package com.scz.restaurantweek.LayoutClassesEvents;

public class EventObject {
    private String nazwa;
    private String cena;

    public EventObject(String nazwa, String cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

}