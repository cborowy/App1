package DAO;


import model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cborowy on 10.07.15.
 */
public class AbstractDAO<E extends Entity> {
    private List<E> lista = new ArrayList<E>();


    private static Random random = new Random();

    public void dodaj(E entity) {
        if (entity == null) throw new IllegalArgumentException();
        entity.setId(random.nextInt());
        lista.add(entity);

    }

    public List<E> getLista()
    {
        return new ArrayList<E>(lista);
    }

    public E znajdz(int id) {
        for (E u : lista) {
            if (u.getId() == id)
                return u;
        }
        throw new IllegalArgumentException();
    }

    public void usun(E entity) {

        lista.remove(entity);
    }


    public void edytuj(E entity){
        if (entity == null)
            throw new IllegalArgumentException();
        for(int i = 0; i < lista.size(); ++i)
        {
            if(lista.get(i).getId() == entity.getId())
            {
                lista.set(i, entity);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

}
