package LoginRelated;

public class Angajat{
    private String nume, prenume, email, parola;
    private int nrLogin, id;
    public Angajat (int id, String nume, String prenume, String email, String parola, int nrLogin){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.nrLogin = nrLogin;
    }

    public String toString (){
        return "ID: " + id + ", nume : " + nume + " , prenume : " + prenume + " , email : " + email + " , parola : " + parola + " , nrLogin : " + nrLogin;
    }

    public String toStringAdmin(){
        return "ID: " + id + ", nume : " + nume + ", prenume: " + prenume;
    }

    public String getEmail(){
        return this.email;
    }

    public String getParola(){
        return this.parola;
    }
    public int getNrLogin(){
        return this.nrLogin;
    }
}
