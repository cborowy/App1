package model;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 06.07.15.
 */
@ManagedBean
public class Rola implements Entity {

    private String nazwa;
    private int id;

    public List<Uprawnienie> uprawnienia = new ArrayList<Uprawnienie>();

    public Rola(){

    }

    public Rola(String nazwa, int id){
        this.nazwa = nazwa;
        this.id = id;
    }

    public Rola(String nazwa){
       this.nazwa = nazwa;
   }

    public List<Uprawnienie> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(ArrayList<Uprawnienie> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rola)) return false;

        Rola rola = (Rola) o;

        return id == rola.id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
