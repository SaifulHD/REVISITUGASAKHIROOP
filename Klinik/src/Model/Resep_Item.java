package Model;

public class Resep_Item {
    String id_resep,id_obat;

    public String getId_resep() {
        return id_resep;
    }

    public void setId_resep(String id_resep) {
        this.id_resep = id_resep;
    }

    public String getId_obat() {
        return id_obat;
    }

    public void setId_obat(String id_obat) {
        this.id_obat = id_obat;
    }

    public Resep_Item(String id_resep, String id_obat) {
        this.id_resep = id_resep;
        this.id_obat = id_obat;
    }
    
    public Resep_Item(){
        
    }

}
