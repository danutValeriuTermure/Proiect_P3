package Produse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdusTest {

    @Test
    void setDiscount1() {
        Produs p = new Produs(1, "1", 1,"1", 1,"1","1");
        p.setDiscount1(true);
        assertEquals(p.isDiscount(), true);
    }

    @Test
    void setDiscount() {
        Produs p = new Produs(1, "1", 1,"1", 1,"1","1");
        p.setDiscount();
        assertEquals(p.isDiscount(), true);
    }

    @Test
    void setPretDiscount() {
        Produs p = new Produs(1, "1", 1,"1", 1,"1","1");
        p.setDiscount1(true);
        p.setPretDiscount(10);
        assertEquals(p.getPret(), 1.0);
    }

    @Test
    void setNrComenzi() {
        Produs p = new Produs(1, "1", 1,"1", 1,"1","1");
        p.setNrComenzi(10);
        assertEquals(p.getNrComenzi(), 10);
    }

    @Test
    void testToString() {
        Produs p = new Produs(1, "1", 1,"1", 1,"1","1");
        String str = "1: categorie: 1, culoare: 1, pret: 1.0 lei";
        assertEquals(p.toString(), str);
    }
}