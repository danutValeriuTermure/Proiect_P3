import java.io.Serializable;

public class Client implements Login, Serializable {

    private String nume, prenume, email, parola;
    private boolean esteClient;

    public Client (String nume, String prenume, String email, String parola){
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

    public String getEmail(){
        return this.email;
    }

    public String getParola(){
        return this.parola;
    }
}
