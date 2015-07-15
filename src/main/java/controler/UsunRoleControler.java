package controler;

import DAO.RoleDAO;
import Form.RolaForm;
import controler.helpers.RolaHelper;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by cborowy on 07.07.15.
 */
@ManagedBean
@RequestScoped
public class UsunRoleControler {

    @ManagedProperty(value = "#{roleDAO}")
    private RoleDAO roleDAO;

    public void usunRole(RolaForm rolaForm){
        roleDAO.usun(RolaHelper.konwertuj(rolaForm));
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}
