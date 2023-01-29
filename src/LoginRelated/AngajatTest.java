package LoginRelated;

import static org.junit.jupiter.api.Assertions.*;

class AngajatTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Angajat a = new Angajat(1, "1", "1", "1", "1", 1);
        String str = "ID: 1, nume : 1 , prenume : 1 , email : 1 , parola : 1 , nrLogin : 1";
        assertEquals(a.toString(), str);
    }
    @org.junit.jupiter.api.Test
    void toStringAdmin() {
        Angajat a = new Angajat(1, "1", "1", "1", "1", 1);
        String str = "ID: 1, nume : 1, prenume: 1";
        assertEquals(a.toStringAdmin(), str);
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        Angajat a = new Angajat(1, "1", "1", "1", "1", 1);
        assertEquals(a.getEmail(), "1");
    }

    @org.junit.jupiter.api.Test
    void getParola() {
        Angajat a = new Angajat(1, "1", "1", "1", "1", 1);
        assertEquals(a.getParola(), "1");
    }

    @org.junit.jupiter.api.Test
    void getNrLogin() {
        Angajat a = new Angajat(1, "1", "1", "1", "1", 1);
        assertEquals(a.getNrLogin(), 1);
    }
}