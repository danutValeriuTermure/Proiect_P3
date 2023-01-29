package LoginRelated;
import Produse.Produs;
import java.util.List;

public class Client implements Login{
    int id;
    private String nume, prenume, email, parola;
    private boolean esteClient;
    private int p1, p2, p3;

    public Client (int id, String nume, String prenume, String email, String parola){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }

    @Override
    public void esteAdmin() {
        esteClient = false;
    }

    @Override
    public void esteAngajat() {
        esteClient = false;
    }

    @Override
    public void esteClient() {
        esteClient = true;
    }

    public String toString (){
        return "Nume : " + nume + " , prenume : " + prenume + " , email : " + email + " , parola : " + parola;
    }

    public int getId(){
        return id;
    }
    public String getEmail(){
        return this.email;
    }

    public String getParola(){
        return this.parola;
    }


    public void setP1(int p1) {
        this.p1 = p1;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }

    public int getP3() {
        return p3;
    }
}
