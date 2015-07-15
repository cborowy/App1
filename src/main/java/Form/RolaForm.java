package Form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 08.07.15.
 */
public class RolaForm {
    private String nazwa;
    private int id;

    public List<String> uprawnieniaTarget = new ArrayList<String>();

    public RolaForm(){
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
