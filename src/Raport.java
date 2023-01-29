public class Raport {
    int id, idProdus;
    String deModificat;
    public Raport(int id, int idProdus, String deModificat){
        this.id = id;
        this.idProdus = idProdus;
        this.deModificat = deModificat;
    }

    public String toString(){
        return "ID raport: " + id + ", id produs: " + idProdus + ", coloana de modificat: " + deModificat;
    }
}
