package Form;

import model.Uprawnienie;

/**
 * Created by cborowy on 08.07.15.
 */
public class UprawnienieForm {

    private String nazwa;
    private String skrot;
    private int id;

    public UprawnienieForm() {
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
