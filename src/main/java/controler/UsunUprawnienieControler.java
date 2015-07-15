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
public class UsunUprawnienieControler {

    @ManagedProperty(value = "#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    public void usunUprawnienie(UprawnienieForm uprawnienieForm){
        uprawnieniaDAO.usun(UprawnienieHelper.konwertuj(uprawnienieForm));
    }

    public UprawnieniaDAO getUprawnieniaDAO() {
        return uprawnieniaDAO;
    }

    public void setUprawnieniaDAO(UprawnieniaDAO uprawnieniaDAO) {
        this.uprawnieniaDAO = uprawnieniaDAO;
    }
}
