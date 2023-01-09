package Produse;

public class Laptop extends Produs{
    private String marca, model, procesor, placaVideo, tipMemorie;
    private int ram, memorie;
    private double dimensiuneEcran, pret;
    private Culori culoare;
    private String sistemOperare;

    public Laptop(){}

    public Laptop(String marca, String model, String procesor, String placaVideo, String tipMemorie, int ram, int memorie,
                      double dimensiuneEcran, double pret, Culori culoare, String sistemOperare){
        this.marca = marca;
        this.model = model;
        this.procesor = procesor;
        this.placaVideo = placaVideo;
        this.tipMemorie = tipMemorie;
        this.ram = ram;
        this.memorie = memorie;
        this.dimensiuneEcran = dimensiuneEcran;
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
