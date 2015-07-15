package controler;

import DAO.RoleDAO;
import DAO.UprawnieniaDAO;
import Form.RolaForm;
import controler.helpers.RolaHelper;
import controler.helpers.UprawnienieHelper;
import model.Uprawnienie;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 09.07.15.
 */

@ManagedBean
@ViewScoped
public class EdytujRoleControler {

    @ManagedProperty(value="#{roleDAO}")
    private RoleDAO roleDAO;

    @ManagedProperty(value="#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    private RolaForm rolaForm;

    private String id;

    private List<String> uprawnieniaSource = new ArrayList<String>();
    private List<String> uprawnieniaTarget = new ArrayList<String>();

    private DualListModel<String> uprawnienia = new DualListModel<String>(uprawnieniaSource, uprawnieniaTarget);


    @PostConstruct
    public void Init(){
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.rolaForm = RolaHelper.konwertuj(roleDAO.znajdz(Integer.parseInt(id)));

        for(String string: rolaForm.uprawnieniaTarget){
            this.uprawnieniaTarget.add(string);
        }

        for(Uprawnienie uprawnienie : uprawnieniaDAO.getLista()){
            if(!uprawnieniaTarget.contains(uprawnienie.getNazwa())){
                uprawnienia.getSource().add(UprawnienieHelper.konwertujDoStringa(uprawnienie));
            }

        }
    }

    public String edytujRole(){
        try {
            roleDAO.edytuj(RolaHelper.konwertuj(rolaForm, uprawnienia.getTarget(), uprawnieniaDAO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/role.xhtml";
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public RolaForm getRolaForm() {
        return rolaForm;
    }

    public void setRolaForm(RolaForm rolaForm) {
        this.rolaForm = rolaForm;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



}
