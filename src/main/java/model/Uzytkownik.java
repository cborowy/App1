package model;

import Form.UzytkownikForm;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cborowy on 06.07.15.
 */
@ManagedBean
public class Uzytkownik implements Entity{

    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private int id;





    public List<Rola> role = new ArrayList<Rola>();

    public Uzytkownik(){

    }

    public Uzytkownik(String imie, String nazwisko, String email, String telefon){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
    }

    public Uzytkownik(String imie, String nazwisko, String email, String telefon, int id){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uzytkownik that = (Uzytkownik) o;

        return id == that.id;

    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getImie() {
        return imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
