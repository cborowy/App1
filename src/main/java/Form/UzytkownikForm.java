package Form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 07.07.15.
 */

public class UzytkownikForm {

    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private int id;

    public List<String> roleTarget = new ArrayList<String>();

    public UzytkownikForm(){

    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
