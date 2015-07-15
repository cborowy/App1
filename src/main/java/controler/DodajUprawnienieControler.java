package controler;

import DAO.UprawnieniaDAO;
import Form.UprawnienieForm;
import controler.helpers.UprawnienieHelper;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by cborowy on 07.07.15.
 */

@ManagedBean
@RequestScoped
public class DodajUprawnienieControler {

    @ManagedProperty(value="#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    private UprawnienieForm uprawnienieForm = new UprawnienieForm();

    public String dodajUprawnienie(){
        uprawnieniaDAO.dodaj(UprawnienieHelper.konwertuj(uprawnienieForm));

        return "/uprawnienia.xhtml";
    }

    public UprawnieniaDAO getUprawnieniaDAO() {
        return uprawnieniaDAO;
    }

    public void setUprawnieniaDAO(UprawnieniaDAO uprawnieniaDAO) {
        this.uprawnieniaDAO = uprawnieniaDAO;
    }

    public UprawnienieForm getUprawnienieForm() {
        return uprawnienieForm;
    }

    public void setUprawnienieForm(UprawnienieForm uprawnienieForm) {
        this.uprawnienieForm = uprawnienieForm;
    }
}
