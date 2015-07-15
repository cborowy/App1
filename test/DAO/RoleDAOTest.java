package DAO;

import model.Rola;
import model.Uprawnienie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cborowy on 10.07.15.
 */
public class RoleDAOTest {

    private RoleDAO roleDAO;

    @Before
    public void setRoleDAO(){
        roleDAO = new RoleDAO();
    }

    @After
    public void clearRoleDAO(){
        roleDAO = null;
    }

    @Test
    public void testDodajUprawnienie(){

        roleDAO.dodaj(new Rola());
        Rola rola = roleDAO.getLista().get(0);

        Uprawnienie uprawnienie = new Uprawnienie("nazwa", "skrot", 1);

        roleDAO.dodajUprawnienie(rola, uprawnienie);

        assertEquals(uprawnienie, roleDAO.getLista().get(0).uprawnienia.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajUprawnienieRolaNieWDAO(){
        Rola rola = new Rola("rola", 1);

        Uprawnienie uprawnienie = new Uprawnienie();
        roleDAO.dodajUprawnienie(rola, uprawnienie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajUprawnienieNullRola(){
        Rola rola = null;
        Uprawnienie uprawnienie = new Uprawnienie();

        roleDAO.dodaj(rola);
        roleDAO.dodajUprawnienie(rola, uprawnienie );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajUprawnienieNullUprawnienie(){

        Rola rola = new Rola();
        Uprawnienie uprawnienie = null;

        roleDAO.dodaj(rola);
        roleDAO.dodajUprawnienie(rola, uprawnienie);
    }

    @Test
    public void testUsunUprawnienie(){
        Rola rola = new Rola("nazwa", 1);

        Uprawnienie uprawnienie = new Uprawnienie();

        roleDAO.dodaj(rola);
        roleDAO.dodajUprawnienie(rola, uprawnienie);
        roleDAO.usunUprawnienie(rola, uprawnienie);

        assertEquals(roleDAO.getLista().get(0).uprawnienia.size(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsunUprawnienieNullUprawnienie(){

        Rola rola = new Rola("nazwa", 1);
        Uprawnienie uprawnienie = null;
        roleDAO.dodaj(rola);

        roleDAO.dodajUprawnienie(rola, uprawnienie);
        roleDAO.usunUprawnienie(rola, uprawnienie);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsunUprawnienieNullRola(){

        Rola rola = null;
        Uprawnienie uprawnienie = new Uprawnienie("nazwa", "skrot", 1);

        roleDAO.dodajUprawnienie(rola, uprawnienie);
        roleDAO.usunUprawnienie(rola, uprawnienie);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsunUprawnienieRolaNieWDAO(){

        Rola rola = new Rola();

        Uprawnienie uprawnienie = new Uprawnienie();

        roleDAO.usunUprawnienie(rola, uprawnienie);

    }

}