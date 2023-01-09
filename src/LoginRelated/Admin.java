package LoginRelated;

public class Admin implements Login{
    private String nume, prenume, email, parola;
    private boolean esteAdmin;

    public Admin (String nume, String prenume, String email, String parola){
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }
    @Override
    public void esteAdmin() {
        esteAdmin = true;
    }

    @Override
    public void esteAngajat() {
        esteAdmin = false;
    }

    @Override
    public void esteClient() {
        esteAdmin = false;
    }
}
