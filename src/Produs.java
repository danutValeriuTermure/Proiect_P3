public class Produs {
    private String categorie;
    private String nume;
    private int numarProd;

    public Produs(String categorie, String nume, int numarProd){
        this.categorie = categorie;
        this.nume = nume;
        this.numarProd = numarProd;
    }

    public String toString (){
        return "Categorie: " + categorie + ", produs: " + nume + ", numar produse: " + numarProd;
    }
}
