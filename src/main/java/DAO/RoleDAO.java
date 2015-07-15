package DAO;

import model.Rola;
import model.Uprawnienie;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cborowy on 07.07.15.
 */


@SessionScoped
@ManagedBean
public class RoleDAO extends AbstractDAO<Rola>{

    public RoleDAO(){


        dodaj( new Rola("Rola1", 1));
        dodaj( new Rola("Rola2", 2));
        dodaj( new Rola("Rola3", 3));


    }

    public void dodajUprawnienie(Rola rola, Uprawnienie uprawnienie){
        if(rola != null && uprawnienie != null){
            for(Rola tempRola : getLista())
                if(tempRola.getId() == rola.getId()){
                    rola.uprawnienia.add(uprawnienie);
                    return;
                }
        }
        throw new IllegalArgumentException();
    }

    public void usunUprawnienie(Rola rola, Uprawnienie uprawnienie){
        if(rola != null && uprawnienie != null){
            for(Rola tempRola : getLista())
                if(tempRola.getId() == rola.getId()){
                    rola.uprawnienia.remove(uprawnienie);
                    return;
                }

        }
        throw new IllegalArgumentException();
    }
}
