package controler.helpers;

import DAO.RoleDAO;
import Form.UzytkownikForm;
import model.Rola;
import model.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 08.07.15.
 */
public class UzytkownikHelper {

    public static List<UzytkownikForm> convertToUzytkownicyForm(List<Uzytkownik> uzytkownicy){
        ArrayList<UzytkownikForm> uzytkownicyForm = new ArrayList<UzytkownikForm>();

        for(Uzytkownik uzytkownik: uzytkownicy){
            uzytkownicyForm.add(konwertuj(uzytkownik));
        }
        return uzytkownicyForm;
    }

    public static  UzytkownikForm konwertuj(Uzytkownik uzytkownik){
        UzytkownikForm uzytkownikForm = new UzytkownikForm();

        uzytkownikForm.setImie(uzytkownik.getImie());
        uzytkownikForm.setNazwisko(uzytkownik.getNazwisko());
        uzytkownikForm.setEmail(uzytkownik.getEmail());
        uzytkownikForm.setTelefon(uzytkownik.getTelefon());
        uzytkownikForm.setId(uzytkownik.getId());

        for(Rola rola : uzytkownik.role){
            uzytkownikForm.roleTarget.add(rola.getNazwa());
        }

        return uzytkownikForm;
    }

    public static Uzytkownik konwertuj(UzytkownikForm uzytkownikForm, List<String> roleTarget, RoleDAO roleDAO){
        Uzytkownik uzytkownik = new Uzytkownik();

        uzytkownik.setImie(uzytkownikForm.getImie());
        uzytkownik.setNazwisko(uzytkownikForm.getNazwisko());
        uzytkownik.setEmail(uzytkownikForm.getEmail());
        uzytkownik.setTelefon(uzytkownikForm.getTelefon());
        uzytkownik.setId(uzytkownikForm.getId());

        for(String string: roleTarget){
            for(Rola rola: roleDAO.getLista()) {
                if(string.equals(rola.getNazwa())){
                    uzytkownik.role.add(rola);
                }

            }
        }

        return uzytkownik;
    }

    public static Uzytkownik konwertuj(UzytkownikForm uzytkownikForm){
        Uzytkownik uzytkownik = new Uzytkownik();

        uzytkownik.setImie(uzytkownikForm.getImie());
        uzytkownik.setNazwisko(uzytkownikForm.getNazwisko());
        uzytkownik.setEmail(uzytkownikForm.getEmail());
        uzytkownik.setTelefon(uzytkownikForm.getTelefon());
        uzytkownik.setId(uzytkownikForm.getId());

        return uzytkownik;
    }
}
