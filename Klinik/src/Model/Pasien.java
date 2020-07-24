package Model;

import java.sql.Date;

public class Pasien {
    String id_pasien,nama,alamat,tgl_lahir;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Pasien() {
        
    }

    public String getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(String id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public Pasien(String id_pasien, String nama, String alamat, String tgl_lahir) {
        this.id_pasien = id_pasien;
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
    }
    
    
}
