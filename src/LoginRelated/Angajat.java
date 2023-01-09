package LoginRelated;

import java.io.Serializable;

public class Angajat implements Login, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String nume, prenume, email, parola;
    private boolean esteAngajat;
    public Angajat (String nume, String prenume, String email, String parola){
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }
    @Override
    public void esteAdmin() {
        esteAngajat = false;
    }

    @Override
    public void esteAngajat() {
        esteAngajat = true;
    }

    @Override
    public void esteClient() {
        esteAngajat = false;
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
