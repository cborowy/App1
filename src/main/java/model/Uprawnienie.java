package model;

import Form.UprawnienieForm;

import javax.faces.bean.ManagedBean;

/**
 * Created by cborowy on 06.07.15.
 */
@ManagedBean
public class Uprawnienie implements Entity {
    private String nazwa;
    private String skrot;
    private int id;


    public Uprawnienie() {

    }

    public Uprawnienie(String nazwa, String skrot) {
        this.nazwa = nazwa;
        this.skrot = skrot;
    }

    public Uprawnienie(String nazwa, String skrot, int id) {
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uprawnienie)) return false;

        Uprawnienie that = (Uprawnienie) o;

        return id == that.id;

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
