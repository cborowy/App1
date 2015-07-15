package controler;

import DAO.RoleDAO;
import DAO.UzytkownicyDAO;
import Form.UzytkownikForm;
import controler.helpers.RolaHelper;
import controler.helpers.UzytkownikHelper;
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
 * Created by cborowy on 06.07.15.
 */

@ManagedBean
@ViewScoped
public class DodajUzytkownikaControler{

    @ManagedProperty(value="#{uzytkownicyDAO}")
    private UzytkownicyDAO uzytkownicyDAO;

    @ManagedProperty(value="#{roleDAO}")
    private RoleDAO roleDAO;

    private List <String> roleSource = new ArrayList<String>();
    private List <String> roleTarget = new ArrayList<String>();

    private DualListModel<String> role  = new DualListModel<String>(roleSource, roleTarget);

    private UzytkownikForm uzytkownikForm = new UzytkownikForm();

    @PostConstruct
    public void init(){
      for(int i = 0; i < roleDAO.getLista().size(); i++)
          roleSource.add(i, RolaHelper.konwertujDoStringa(roleDAO.getLista().get(i)));

    }

    public UzytkownikForm getUzytkownikForm() {
        return uzytkownikForm;
    }

    public void setUzytkownikForm(UzytkownikForm uzytkownikForm) {
        this.uzytkownikForm = uzytkownikForm;
    }

    public UzytkownicyDAO getUzytkownicyDAO() {
        return uzytkownicyDAO;
    }

    public void setUzytkownicyDAO(UzytkownicyDAO uzytkownicyDAO) {
        this.uzytkownicyDAO = uzytkownicyDAO;
    }

    public String dodajUzytkownika(){

        uzytkownicyDAO.dodaj(UzytkownikHelper.konwertuj(uzytkownikForm, role.getTarget(), roleDAO));
        return "/uzytkownicy.xhtml";

    }

    public List<String> getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(List<String> roleSource) {
        this.roleSource = roleSource;
    }

    public List<String> getRoleTarget() {
        return roleTarget;
    }

    public void setRoleTarget(List<String> roleTarget) {
        this.roleTarget = roleTarget;
    }

    public DualListModel<String> getRole() {
        return role;
    }

    public void setRole(DualListModel<String> role) {
        this.role = role;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


}
