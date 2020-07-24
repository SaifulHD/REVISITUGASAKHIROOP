package Model;

public class Pegawai {
    String id_pegawai,id_jabatan,username,nama,gender,tgl_lahir;

    public String getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(String id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public Pegawai(String id_pegawai, String id_jabatan, String username, String nama, String gender, String tgl_lahir) {
        this.id_pegawai = id_pegawai;
        this.id_jabatan = id_jabatan;
        this.username = username;
        this.nama = nama;
        this.gender = gender;
        this.tgl_lahir = tgl_lahir;
    }
    
    public Pegawai(){
        
    }
}
