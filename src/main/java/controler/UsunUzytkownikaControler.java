package controler;

import DAO.UzytkownicyDAO;
import Form.UzytkownikForm;
import controler.helpers.UzytkownikHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by cborowy on 07.07.15.
 */

@ManagedBean
@RequestScoped
public class UsunUzytkownikaControler {

    @ManagedProperty(value = "#{uzytkownicyDAO}")
    private UzytkownicyDAO uzytkownicyDAO;

    public void usunUzytkownika(UzytkownikForm uzytkownikForm){
        uzytkownicyDAO.usun(UzytkownikHelper.konwertuj(uzytkownikForm));
        System.out.println(uzytkownikForm.getId());
    }

    public UzytkownicyDAO getUzytkownicyDAO() {
        return uzytkownicyDAO;
    }

    public void setUzytkownicyDAO(UzytkownicyDAO uzytkownicyDAO) {
        this.uzytkownicyDAO = uzytkownicyDAO;
    }


}
