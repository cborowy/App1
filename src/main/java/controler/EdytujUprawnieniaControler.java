package controler;

import DAO.UprawnieniaDAO;
import Form.UprawnienieForm;
import controler.helpers.UprawnienieHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 * Created by cborowy on 08.07.15.
 */
@ManagedBean
@ViewScoped
public class EdytujUprawnieniaControler {

    @ManagedProperty(value="#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    private UprawnienieForm uprawnienieForm;

    private String id;


    @PostConstruct
    public void Init(){
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.uprawnienieForm = UprawnienieHelper.konwertuj(uprawnieniaDAO.znajdz(Integer.parseInt(id)));


    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
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

    public String edytujUprawnienie(){
        try {
            uprawnieniaDAO.edytuj(UprawnienieHelper.konwertuj(uprawnienieForm));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return"/uprawnienia.xhtml";
    }

}
