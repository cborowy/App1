package DAO;

import model.Rola;
import model.Uzytkownik;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by cborowy on 06.07.15.
 */


@SessionScoped
@ManagedBean
public class UzytkownicyDAO extends AbstractDAO<Uzytkownik>{

    public UzytkownicyDAO() {

    }

    public void dodajRole(Uzytkownik uzytkownik, Rola rola) {
        if (uzytkownik != null && rola != null) {
            for (Uzytkownik tempUzytkownik : getLista())
                if (tempUzytkownik.getId() == uzytkownik.getId()) {
                    uzytkownik.role.add(rola);
                    return;
                }
        }
        throw new IllegalArgumentException();
    }

    public void usunRole(Uzytkownik uzytkownik, Rola rola) {
        if (uzytkownik != null && rola != null) {
            for (Uzytkownik tempUzytkownik : getLista())
                if (tempUzytkownik.getId() == uzytkownik.getId()) {
                    uzytkownik.role.remove(rola);
                    return;
                }
        }
        throw new IllegalArgumentException();
    }

}
