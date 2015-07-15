package controler.helpers;

import DAO.UprawnieniaDAO;
import Form.RolaForm;
import model.Rola;
import model.Uprawnienie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 09.07.15.
 */
public class RolaHelper {

    public static List<RolaForm> convertToRolaForm(List<Rola> role){
        ArrayList<RolaForm> roleForm = new ArrayList<RolaForm>();

        for(Rola rola: role){
            roleForm.add(konwertuj(rola));
        }
        return roleForm;
    }

    public static RolaForm konwertuj(Rola rola){
        RolaForm rolaForm = new RolaForm();

        rolaForm.setNazwa(rola.getNazwa());
        rolaForm.setId(rola.getId());

        for(Uprawnienie uprawnienie : rola.uprawnienia){
            rolaForm.uprawnieniaTarget.add(uprawnienie.getNazwa());
        }

        return rolaForm;
    }

    public static Rola konwertuj(RolaForm rolaForm, List<String> uprawnieniaTarget, UprawnieniaDAO uprawnieniaDAO){
        Rola rola = new Rola();

        rola.setNazwa(rolaForm.getNazwa());
        rola.setId(rolaForm.getId());

        for(String string: uprawnieniaTarget){
            for(Uprawnienie uprawnienie: uprawnieniaDAO.getLista()){
                if(string.equals(uprawnienie.getNazwa())){
                    rola.uprawnienia.add(uprawnienie);
                }
            }
        }

        return rola;
    }

    public static Rola konwertuj(RolaForm rolaForm){
        Rola rola = new Rola();

        rola.setNazwa(rolaForm.getNazwa());
        rola.setId(rolaForm.getId());

        return rola;
    }

    public static String konwertujDoStringa(Rola rola){
        return rola.getNazwa();
    }
}
