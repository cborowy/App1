package controler;

import DAO.RoleDAO;
import Form.RolaForm;
import controler.helpers.RolaHelper;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by cborowy on 07.07.15.
 */
@ManagedBean
@RequestScoped
public class PobierzRoleControler {

    private List<RolaForm> listaRolForm;

    @ManagedProperty(value = "#{roleDAO}")
    private RoleDAO roleDAO;

    @PostConstruct
    public void pobierzListe(){
        listaRolForm = RolaHelper.convertToRolaForm(roleDAO.getLista());
    }

    public List<RolaForm> getListaRolForm() {
        return listaRolForm;
    }

    public void setListaRolForm(List<RolaForm> listaRolForm) {
        this.listaRolForm = listaRolForm;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public String setURL(String id){
        return "/edytujrole.xhtml?faces-redirect=true&id=" + id;
    }
}

