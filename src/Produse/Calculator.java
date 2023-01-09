package Produse;

public class Calculator extends Produs{
    private String marca, model, procesor, placaVideo, tipMemorie;
    private int ram, memorie;
    private double greutate, pret;
    private Culori culoare;
    private String sistemOperare;

    public Calculator(){}

    public Calculator(String marca, String model, String procesor, String placaVideo, String tipMemorie, int ram, int memorie,
                      double greutate, double pret, Culori culoare, String sistemOperare){
        this.marca = marca;
        this.model = model;
        this.procesor = procesor;
        this.placaVideo = placaVideo;
        this.tipMemorie = tipMemorie;
        this.ram = ram;
        this.memorie = memorie;
        this.greutate = greutate;
        this.pret = pret;
        this.culoare = culoare;
        this.sistemOperare = sistemOperare;
    }

    public String toString(){
        return marca + " " + model + " " + pret;
    }

    public double getPret(){
        return this.pret;
    }
}
