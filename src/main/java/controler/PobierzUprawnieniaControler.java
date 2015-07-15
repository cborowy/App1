package controler;

import DAO.UprawnieniaDAO;
import model.Uprawnienie;


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
public class PobierzUprawnieniaControler {

    private List<Uprawnienie> listaUprawnien;

    @ManagedProperty(value = "#{uprawnieniaDAO}")
    private UprawnieniaDAO uprawnieniaDAO;

    @PostConstruct
    public void pobierzListe(){
        listaUprawnien= uprawnieniaDAO.getLista();
    }

    public String setURL(String ID){
        return"/edytujuprawnienie.xhtml?faces-redirect=true&id=" + ID;
    }

    public List<Uprawnienie> getListaUprawnien(){
        return listaUprawnien;
    }

    public UprawnieniaDAO getUprawnieniaDAO() {
        return uprawnieniaDAO;
    }

    public void setListaUprawnien(List<Uprawnienie> listaUprawnien) {
        this.listaUprawnien = listaUprawnien;
    }

    public void setUprawnieniaDAO(UprawnieniaDAO uprawnieniaDAO) {
        this.uprawnieniaDAO = uprawnieniaDAO;
    }


}
