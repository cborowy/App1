package controler.helpers;

import Form.UprawnienieForm;
import model.Uprawnienie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 09.07.15.
 */
public class UprawnienieHelper {
    public static List<UprawnienieForm> convertToUprawnienieForm(List<Uprawnienie> uprawnienia) {
        ArrayList<UprawnienieForm> uprawnieniaForm = new ArrayList<UprawnienieForm>();

        for (Uprawnienie uprawnienie : uprawnienia) {
            uprawnieniaForm.add(konwertuj(uprawnienie));

        }
        return uprawnieniaForm;
    }

    public static UprawnienieForm konwertuj(Uprawnienie uprawnienie){
        UprawnienieForm uprawnienieForm = new UprawnienieForm();

        uprawnienieForm.setNazwa(uprawnienie.getNazwa());
        uprawnienieForm.setSkrot(uprawnienie.getSkrot());
        uprawnienieForm.setId(uprawnienie.getId());
        return uprawnienieForm;

    }

    public static Uprawnienie konwertuj(UprawnienieForm uprawnienieForm){
        Uprawnienie uprawnienie = new Uprawnienie();

        uprawnienie.setNazwa(uprawnienieForm.getNazwa());
        uprawnienie.setSkrot(uprawnienieForm.getSkrot());
        uprawnienie.setId(uprawnienieForm.getId());

        return uprawnienie;
    }

    public static String konwertujDoStringa(Uprawnienie uprawnienie){
        return uprawnienie.getNazwa();
    }
}