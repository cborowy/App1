package controler;

import DAO.RoleDAO;
import DAO.UprawnieniaDAO;
import Form.RolaForm;
import controler.helpers.RolaHelper;
import controler.helpers.UprawnienieHelper;
import model.Rola;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 07.07.15.
 */
@ManagedBean
@ViewScoped
public class DodajRoleControler {

    @ManagedProperty(value="#{roleDAO}")
    private RoleDAO roleDAO;

    @ManagedProperty(value="#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    private List<String> uprawnieniaSource = new ArrayList<String>();
    private List<String> uprawnieniaTarget = new ArrayList<String>();

    private DualListModel<String> uprawnienia = new DualListModel<String>(uprawnieniaSource, uprawnieniaTarget);

    private RolaForm rolaForm = new RolaForm();

    @PostConstruct
    public void init(){
        for(int i = 0; i < uprawnieniaDAO.getLista().size(); i++)
            uprawnieniaSource.add(i, UprawnienieHelper.konwertujDoStringa(uprawnieniaDAO.getLista().get(i)));
    }





    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public String dodajRole(){
        roleDAO.dodaj(RolaHelper.konwertuj(rolaForm, uprawnienia.getTarget(),uprawnieniaDAO));
        return "/role.xhtml";
    }

    public UprawnieniaDAO getUprawnieniaDAO() {
        return uprawnieniaDAO;
    }

    public void setUprawnieniaDAO(UprawnieniaDAO uprawnieniaDAO) {
        this.uprawnieniaDAO = uprawnieniaDAO;
    }

    public List<String> getUprawnieniaSource() {
        return uprawnieniaSource;
    }

    public void setUprawnieniaSource(List<String> uprawnieniaSource) {
        this.uprawnieniaSource = uprawnieniaSource;
    }

    public List<String> getUprawnieniaTarget() {
        return uprawnieniaTarget;
    }

    public void setUprawnieniaTarget(List<String> uprawnieniaTarget) {
        this.uprawnieniaTarget = uprawnieniaTarget;
    }

    public DualListModel<String> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(DualListModel<String> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public RolaForm getRolaForm() {
        return rolaForm;
    }

    public void setRolaForm(RolaForm rolaForm) {
        this.rolaForm = rolaForm;
    }
}
