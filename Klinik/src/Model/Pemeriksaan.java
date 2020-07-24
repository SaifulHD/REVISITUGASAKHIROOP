package Model;

public class Pemeriksaan {
    String id_pemeriksaan,tgl_pemeriksaan,id_pegawai,id_pasien;
    public String getId_pemeriksaan() {
        return id_pemeriksaan;
    }

    public void setId_pemeriksaan(String id_pemeriksaan) {
        this.id_pemeriksaan = id_pemeriksaan;
    }

    public String getTgl_pemeriksaan() {
        return tgl_pemeriksaan;
    }

    public void setTgl_pemeriksaan(String tgl_pemeriksaan) {
        this.tgl_pemeriksaan = tgl_pemeriksaan;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(String id_pasien) {
        this.id_pasien = id_pasien;
    }

    public Pemeriksaan(String id_pemeriksaan, String tgl_pemeriksaan, String id_pegawai, String id_pasien) {
        this.id_pemeriksaan = id_pemeriksaan;
        this.tgl_pemeriksaan = tgl_pemeriksaan;
        this.id_pegawai = id_pegawai;
        this.id_pasien = id_pasien;
    }
    
    public Pemeriksaan(){
        
    }


    
}
