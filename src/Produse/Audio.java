package Produse;

public class Audio extends Produs{
    private String marca, model, tip;
    private double greutate, pret;
    private Culori culoare;
    private Conectivitati conectivitate;

    public Audio(){}

    public Audio(String marca, String model, String tip, double greutate, double pret, Culori culoare, Conectivitati conectivitate){
        this.marca = marca;
        this.model = model;
        this.tip = tip;
        this.greutate = greutate;
        this.pret = pret;
        this.culoare = culoare;
        this.conectivitate = conectivitate;
    }

    public Audio (String tip, String marca, double pret){
        this.tip = tip;
        this.marca = marca;
        this.pret = pret;
    }

    public String toString(){
        return tip + " " + marca + " " + pret;
    }

    public double getPret(){
        return this.pret;
    }

    public void setPret(double p){
        this.pret = p;
    }
}
