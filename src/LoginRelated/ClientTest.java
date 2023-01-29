package LoginRelated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testToString() {
        Client c = new Client(1, "1", "1", "1", "1");
        String str = "Nume : 1 , prenume : 1 , email : 1 , parola : 1";
        assertEquals(c.toString(), str);
    }

    @Test
    void getId() {
        Client c = new Client(1, "1", "1", "1", "1");
        assertEquals(c.getId(), 1);
    }

    @Test
    void getEmail() {
        Client c = new Client(1, "1", "1", "1", "1");
        assertEquals(c.getEmail(), "1");
    }

    @Test
    void getParola() {
        Client c = new Client(1, "1", "1", "1", "1");
        assertEquals(c.getParola(), "1");
    }

    @Test
    void setP1() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP1(1);
        assertEquals(c.getP1(), 1);
    }

    @Test
    void setP2() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP2(1);
        assertEquals(c.getP2(), 1);
    }

    @Test
    void setP3() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP3(1);
        assertEquals(c.getP3(), 1);
    }

    @Test
    void getP1() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP1(1);
        assertEquals(c.getP1(), 1);
    }

    @Test
    void getP2() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP2(1);
        assertEquals(c.getP2(), 1);
    }

    @Test
    void getP3() {
        Client c = new Client(1, "1", "1", "1", "1");
        c.setP2(1);
        assertEquals(c.getP2(), 1);
    }
}