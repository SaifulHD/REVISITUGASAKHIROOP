package Model;

public class Obat {
    String id_obat,nama,harga;

    public String getId_obat() {
        return id_obat;
    }

    public void setId_obat(String id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Obat(String id_obat, String nama, String harga) {
        this.id_obat = id_obat;
        this.nama = nama;
        this.harga = harga;
    }
    
    public Obat(){
        
    }
}
