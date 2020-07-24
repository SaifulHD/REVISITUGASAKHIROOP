/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Model.Obat;
import Model.Pasien;
import Model.Pemeriksaan;
import Model.Resep;
import Model.Resep_Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import klinik.view.DokterView;

/**
 *
 * @author ASUS
 */
public class Execute {
    
    public String InsertPasien(Pasien psn){
        String query = "INSERT INTO pasien (nama,alamat,tgl_lahir) "+"VALUES (?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String Respon;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, psn.getNama());
            pstm.setString(2, psn.getAlamat());
            pstm.setString(3, psn.getTgl_lahir());
            pstm.executeUpdate();
            Respon="Insert Sukses";
        } catch (SQLException ex) {
            Respon="Insert Gagal";  
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return Respon;
    }
    
    public String InsertPemeriksaan(Pemeriksaan pmr){
        String query = "INSERT INTO pemeriksaan (tgl_pemeriksaan,id_pegawai,id_pasien) "+"VALUES (?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String id_periksa = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, pmr.getTgl_pemeriksaan());
            pstm.setString(2, pmr.getId_pegawai());
            pstm.setString(3, pmr.getId_pasien());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        String query2 = "SELECT * from pemeriksaan where tgl_pemeriksaan='"+pmr.getTgl_pemeriksaan()+"' and id_pegawai='"+pmr.getId_pegawai()+"' and id_pasien = "+pmr.getId_pasien()+"";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query2);
            if (rs.next()) {
                id_periksa = rs.getString("id_pemeriksaan");
                System.out.println("BERHASIL NICH");
            } else {
                JOptionPane.showMessageDialog(null, "COBA LAGIIIII !!!!");
            }
        } catch (SQLException e) {
        }     
        conMan.Logoff();
        return id_periksa;
    }
    
    public String InsertResep(Resep rsp){
        String query = "INSERT INTO resep (id_pemeriksaan) "+"VALUES (?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String id_resp = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, rsp.getId_pemeriksaan());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        String query2 = "SELECT * from resep where id_pemeriksaan="+rsp.getId_pemeriksaan()+"";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query2);
            if (rs.next()) {
                id_resp = rs.getString("id_resep");
            } else {
                JOptionPane.showMessageDialog(null, "COBA LAGIIIII !!!!");
            }
        } catch (SQLException e) {
        }     
        conMan.Logoff();
        return id_resp;
    }
    
    public String InsertResep_Item(Resep_Item rsp_itm){
        String query = "INSERT INTO list_obat (id_resep,id_obat) "+"VALUES (?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String Respon;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, rsp_itm.getId_resep());
            pstm.setString(2, rsp_itm.getId_obat());
            pstm.executeUpdate();
            Respon="Insert Sukses";
        } catch (SQLException ex) {
            Respon="Insert Gagal";  
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return Respon;
    }
    
    public ArrayList<Pasien> ListPasienBlmDiperiksa(){   
        ArrayList<Pasien> arlistpsn = new ArrayList<>();
        String query = "SELECT pasien.id_pasien,nama,alamat,tgl_lahir FROM pasien LEFT JOIN pemeriksaan ON pasien.id_pasien = pemeriksaan.id_pasien WHERE pemeriksaan.id_pasien IS null";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Pasien psn = new Pasien();
                psn.setNama(rs.getString("nama"));
                psn.setAlamat(rs.getString("alamat"));
                psn.setTgl_lahir(rs.getString("tgl_lahir"));
                arlistpsn.add(psn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return arlistpsn;
    }
    
    public ArrayList<Resep> ListResep(){   
        ArrayList<Resep> arlistrsp = new ArrayList<>();
        String query = "SELECT * FROM resep WHERE pembayaran = '-'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Resep rsp = new Resep();
                rsp.setId_resep(rs.getString("id_resep"));
                rsp.setId_pemeriksaan(rs.getString("id_pemeriksaan"));
                arlistrsp.add(rsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return arlistrsp;
    }
    
    public ArrayList<Resep> ListResep_stripbayar(){   
        ArrayList<Resep> arlistrsp = new ArrayList<>();
        String query = "SELECT * FROM resep WHERE pembayaran = 'Belum'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Resep rsp = new Resep();
                rsp.setId_resep(rs.getString("id_resep"));
                rsp.setId_pemeriksaan(rs.getString("id_pemeriksaan"));
                arlistrsp.add(rsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return arlistrsp;
    }
   
    public ArrayList<Resep> ListResep_bayar2(){   
        ArrayList<Resep> arlistrsp = new ArrayList<>();
        String query = "SELECT * FROM resep WHERE pembayaran = 'Belum'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Resep rsp = new Resep();
                rsp.setId_resep(rs.getString("id_resep"));
                rsp.setId_pemeriksaan(rs.getString("id_pemeriksaan"));
                arlistrsp.add(rsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return arlistrsp;
    }
    
    public ArrayList<Resep_Item> ListResep_Item(String id_resep){   
        ArrayList<Resep_Item> arlistrsp_itm = new ArrayList<>();
        String query = "SELECT list_obat.id_resep,list_obat.id_obat, obat.nama FROM list_obat LEFT JOIN obat ON list_obat.id_obat = obat.id_obat WHERE list_obat.id_resep ="+id_resep+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Resep_Item rsp_item = new Resep_Item();
                rsp_item.setId_resep(rs.getString("id_resep"));
                rsp_item.setId_obat(rs.getString("id_obat"));
                arlistrsp_itm.add(rsp_item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return arlistrsp_itm;
    }

    public ArrayList<Obat> ListObat(String id1){   
        ArrayList<Obat> lstobat = new ArrayList<>();
        String query = "SELECT list_obat.id_obat,obat.nama,obat.harga from obat LEFT JOIN list_obat ON list_obat.id_obat = obat.id_obat WHERE id_resep = "+id1+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Obat ob = new Obat();
                ob.setId_obat(rs.getString("id_obat"));
                ob.setNama(rs.getString("nama"));
                ob.setHarga(rs.getString("harga"));
                lstobat.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return lstobat;
    }
    
    public String UpdateStripBayar(Resep rsp,String id_risip){
        String hasil="";
        String query ="UPDATE resep SET pembayaran = 'Belum' WHERE id_resep ="+id_risip+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Berhasil";
        } 
        catch (SQLException ex) {
            hasil="Gagal";
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil; 
    }
    
    public String UpdateBelumBayar(Resep rsp,String id_risip){
        String hasil="";
        String query ="UPDATE resep SET pembayaran = 'Sudah' WHERE id_resep ="+id_risip+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Berhasil";
        } 
        catch (SQLException ex) {
            hasil="Gagal";
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil; 
    }
}
