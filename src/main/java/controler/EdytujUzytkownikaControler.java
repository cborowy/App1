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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 07.07.15.
 */
@ManagedBean
@ViewScoped
public class EdytujUzytkownikaControler {

    @ManagedProperty(value = "#{uzytkownicyDAO}")
    private UzytkownicyDAO uzytkownicyDAO;

    @ManagedProperty(value="#{roleDAO}")
    private RoleDAO roleDAO;


    private UzytkownikForm uzytkownikForm;


    private String id;


    private List <String> roleSource = new ArrayList<String>();
    private List <String> roleTarget = new ArrayList<String>();

    private DualListModel<String> role = new DualListModel<String>(roleSource, roleTarget);


    @PostConstruct
    public void Init(){
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.uzytkownikForm = UzytkownikHelper.konwertuj(uzytkownicyDAO.znajdz(Integer.parseInt(id)));

        for(String string : uzytkownikForm.roleTarget){
            this.roleTarget.add(string);
        }


        for(Rola rola : roleDAO.getLista()){
            if(!roleTarget.contains(rola.getNazwa())){
                role.getSource().add(RolaHelper.konwertujDoStringa(rola));
            }
        }
    }

    public UzytkownicyDAO getUzytkownicyDAO() {
        return uzytkownicyDAO;
    }

    public void setUzytkownicyDAO(UzytkownicyDAO uzytkownicyDAO) {
        this.uzytkownicyDAO = uzytkownicyDAO;
    }

    public UzytkownikForm getUzytkownikForm() {
        return uzytkownikForm;
    }

    public void setUzytkownikForm(UzytkownikForm uzytkownikForm) {
        this.uzytkownikForm = uzytkownikForm;
    }

    public String edytujUzytkownika(){
        try {
            uzytkownicyDAO.edytuj(UzytkownikHelper.konwertuj(uzytkownikForm, role.getTarget(), roleDAO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/uzytkownicy.xhtml";
    }

    public List<String> getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(List<String> roleSource) {
        this.roleSource = roleSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
