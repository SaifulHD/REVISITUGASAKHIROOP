package Model;

public class Resep {
    String id_resep,id_pemeriksaan,pembayaran;

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getId_resep() {
        return id_resep;
    }

    public void setId_resep(String id_resep) {
        this.id_resep = id_resep;
    }

    public String getId_pemeriksaan() {
        return id_pemeriksaan;
    }

    public void setId_pemeriksaan(String id_pemeriksaan) {
        this.id_pemeriksaan = id_pemeriksaan;
    }

    public Resep(String id_resep,String id_pemeriksaan,String pembayaran) {
        this.id_resep = id_resep;
        this.id_pemeriksaan = id_pemeriksaan;
        this.pembayaran = pembayaran;
    }
    
    public Resep(){
        
    }
}
