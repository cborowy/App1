package DAO;

import model.Rola;
import model.Uzytkownik;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

/**
 * Created by cborowy on 08.07.15.
 */
public class UzytkownicyDAOTest {

    private UzytkownicyDAO uzytkownicyDAO;

    @Before
    public void setUserDAO(){
        uzytkownicyDAO = new UzytkownicyDAO();
    }

    @After
    public void clearUserDAO(){
        uzytkownicyDAO = null;
    }

    @Test
    public void testDodajUzytkownika() throws Exception {

        Uzytkownik uzytkownik = createUzytkownik();

        uzytkownicyDAO.dodaj(uzytkownik);
        uzytkownicyDAO.getLista().clear();

        assertEquals(1, uzytkownicyDAO.getLista().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajUzytkownikaNullArgument() throws Exception {
        UzytkownicyDAO uzytkownicyDAO = new UzytkownicyDAO();

        uzytkownicyDAO.dodaj(null);
    }

    @Test
    public void testUsunUzytkownika() throws Exception {
        Uzytkownik uzytkownik1 = createUzytkownik();
        Uzytkownik uzytkownik2 = createUzytkownik();

        uzytkownicyDAO.dodaj(uzytkownik1);
        uzytkownicyDAO.dodaj(uzytkownik2);

        uzytkownicyDAO.usun(uzytkownik1);

        assertEquals(1, uzytkownicyDAO.getLista().size());
    }

    @Test
    public void testEdytujUzytkownika()throws Exception{

        Uzytkownik uzytkownik = new Uzytkownik("imie", "nazwisko", "email", "telefon", 1);
        Uzytkownik uzytkownik1 = new Uzytkownik("imie1", "nazwisko1", "email1", "telefon1", 1);

        uzytkownicyDAO.dodaj(uzytkownik);
        uzytkownik.setId(uzytkownik1.getId());
        uzytkownicyDAO.edytuj(uzytkownik1);

        assertEquals(uzytkownicyDAO.getLista().get(0).getImie(), uzytkownik1.getImie());
        assertEquals(uzytkownicyDAO.getLista().get(0).getNazwisko(), uzytkownik1.getNazwisko());
        assertEquals(uzytkownicyDAO.getLista().get(0).getEmail(), uzytkownik1.getEmail());
        assertEquals(uzytkownicyDAO.getLista().get(0).getTelefon(), uzytkownik1.getTelefon());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEdytujUzytkownikaNullUser() throws Exception{
        Uzytkownik uzytkownik = new Uzytkownik("imie", "nazwisko", "email", "telefon", 1);
        Uzytkownik uzytkownik1 = null;
        uzytkownicyDAO.dodaj(uzytkownik);
        uzytkownicyDAO.edytuj(uzytkownik1);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testEdytujUzytkownikaBrakNaLiscie() throws Exception{
        Uzytkownik uzytkownik = new Uzytkownik("imie", "nazwisko", "email", "telefon", 1);
        Uzytkownik uzytkownik1 = new Uzytkownik("imie1", "nazwisko1", "email1", "telefon1", 2);
        uzytkownicyDAO.dodaj(uzytkownik);
        uzytkownicyDAO.edytuj(uzytkownik1);


    }



    @Test
    public void testZnajdzUzytkownika() throws Exception{

        Uzytkownik uzytkownik1 = createUzytkownik();
        Uzytkownik uzytkownik2 = createUzytkownik();
        Uzytkownik uzytkownik3 = createUzytkownik();

        uzytkownicyDAO.dodaj(uzytkownik1);
        uzytkownicyDAO.dodaj(uzytkownik2);
        uzytkownicyDAO.dodaj(uzytkownik3);

        assertEquals(uzytkownik2, uzytkownicyDAO.znajdz(uzytkownik2.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZnajdzUzytkownikaBrakUzytkownika() throws Exception{
        Uzytkownik uzytkownik = createUzytkownik();
        uzytkownicyDAO.znajdz(uzytkownik.getId());
    }

    @Test
    public void testDodajRole() {

        uzytkownicyDAO.dodaj(new Uzytkownik());
        Uzytkownik uzytkownik = uzytkownicyDAO.getLista().get(0);
        Rola rola = createRola();
        uzytkownicyDAO.dodajRole(uzytkownik, rola);

        assertEquals(rola, uzytkownicyDAO.getLista().get(0).role.get(0));


    }


    @Test(expected = IllegalArgumentException.class)
    public  void testDodajRoleUserNieWDAO() {

        Uzytkownik uzytkownik = createUzytkownik();

        Rola rola = createRola();
        uzytkownicyDAO.dodajRole(uzytkownik, rola);

    }


    @Test(expected = IllegalArgumentException.class)
    public  void testDodajRoleNullUser() {

        Uzytkownik uzytkownik = null;
        uzytkownicyDAO.dodaj(uzytkownik);
        Rola rola = createRola();
        uzytkownicyDAO.dodajRole(uzytkownik, rola);

    }

    @Test(expected = IllegalArgumentException.class)
    public  void testDodajRoleNullRole() {

        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownicyDAO.dodaj(uzytkownik);
        Rola rola = null;
        uzytkownicyDAO.dodajRole(uzytkownik,rola);

    }

    @Test(expected = IllegalArgumentException.class)
    public  void testUsunRoleNullRola() {

        Uzytkownik uzytkownik = createUzytkownik();

        uzytkownicyDAO.dodaj(uzytkownik);

        Rola rola = null;

        uzytkownicyDAO.dodajRole(uzytkownik, rola);
        uzytkownicyDAO.usunRole(uzytkownik, rola);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void testUsunRoleNullUer() {

        Uzytkownik uzytkownik = null;

        uzytkownicyDAO.dodaj(uzytkownik);

        Rola rola = createRola();

        uzytkownicyDAO.dodajRole(uzytkownik, rola);
        uzytkownicyDAO.usunRole(uzytkownik, rola);
    }


    @Test(expected = IllegalArgumentException.class)
    public  void testUsunRoleUserNieWDAO() {

        Uzytkownik uzytkownik = createUzytkownik();

        Rola rola = new Rola();
        uzytkownicyDAO.usunRole(uzytkownik, rola);
    }

    @Test
    public void testUsunRole() {

        Uzytkownik uzytkownik = createUzytkownik();

        uzytkownicyDAO.dodaj(uzytkownik);

        Rola rola = createRola();

        uzytkownicyDAO.dodajRole(uzytkownik, rola);
        uzytkownicyDAO.usunRole(uzytkownik, rola);

        assertEquals(uzytkownicyDAO.getLista().get(0).role.size(), 0);
    }

    private Rola createRola() {
        Rola rola = new Rola();
        return rola;
    }

    private Uzytkownik createUzytkownik() {
        Uzytkownik uzytkownikForm = new Uzytkownik();
        uzytkownikForm.setId(1);
        uzytkownikForm.setImie("Zenek");
        uzytkownikForm.setNazwisko("Kowalski");
        uzytkownikForm.setTelefon("2354243");
        uzytkownikForm.setEmail("zenek.kowalski@coi.gov.pl");
        return uzytkownikForm;
    }

}