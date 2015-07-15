package DAO;

import model.Uprawnienie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by cborowy on 06.07.15.
 */
@SessionScoped
@ManagedBean
public class UprawnieniaDAO extends AbstractDAO<Uprawnienie>{

    public UprawnieniaDAO(){
        dodaj(new Uprawnienie("Uprawnienie1", "skrot"));
        dodaj(new Uprawnienie("Uprawnienie2", "skrot"));
        dodaj(new Uprawnienie("Uprawnienie3", "skrot"));
    }

}
