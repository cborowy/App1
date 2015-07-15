package controler;

import DAO.UzytkownicyDAO;
import Form.UzytkownikForm;
import controler.helpers.UzytkownikHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by cborowy on 06.07.15.
 */

@ManagedBean
@RequestScoped
public class PobierzUzytkownikaControler {

    private List<UzytkownikForm> listaUzytkownikowForm;

    @ManagedProperty(value = "#{uzytkownicyDAO}")
    private UzytkownicyDAO uzytkownicyDAO;

    @PostConstruct
    public void pobierzListe(){
        listaUzytkownikowForm = UzytkownikHelper.convertToUzytkownicyForm(uzytkownicyDAO.getLista());
        System.out.println("Lista Pobrana");
    }

    public List<UzytkownikForm> getListaUzytkownikowForm() {
        return listaUzytkownikowForm;
    }

    public void setListaUzytkownikowForm(List<UzytkownikForm> listaUzytkownikowForm) {
        this.listaUzytkownikowForm = listaUzytkownikowForm;
    }

    public UzytkownicyDAO getUzytkownicyDAO() {
        return uzytkownicyDAO;
    }

    public void setUzytkownicyDAO(UzytkownicyDAO uzytkownicyDAO) {
        this.uzytkownicyDAO = uzytkownicyDAO;
    }


    public String setURL(String ID){
        return "/edytujuzytkownika.xhtml?faces-redirect=true&id=" + ID;
    }
}
