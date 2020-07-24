package Adapter;

import Controller.Execute;
import Model.Obat;
import Model.Pasien;
import Model.Resep;
import Model.Resep_Item;
import java.util.List;

public class Adapter {

    public Object[][] getPasienBlmPeriksa(){
        Execute exe = new Execute();
        List<Pasien>lstpsn = exe.ListPasienBlmDiperiksa();
        Object[][] datapsn = new Object[lstpsn.size()][3];
        
        int mysize = 0;
        for (Pasien psn:lstpsn){
            datapsn[mysize][0]=psn.getNama();
            datapsn[mysize][1]=psn.getAlamat();
            datapsn[mysize][2]=psn.getTgl_lahir();
            mysize++;
        }
        return datapsn;
    }
    
    public Object[][] getResepStripProses(){
        Execute exe = new Execute();
        List<Resep>lstrsp = exe.ListResep();
        Object[][] datarsp = new Object[lstrsp.size()][2];
        
        int mysize = 0;
        for (Resep rsp:lstrsp){
            datarsp[mysize][0]=rsp.getId_resep();
            datarsp[mysize][1]=rsp.getId_pemeriksaan();
            mysize++;
        }
        return datarsp;
    }
    
    public Object[][] getResepBlmProses(){
        Execute exe = new Execute();
        List<Resep>lstrsp = exe.ListResep_stripbayar();
        Object[][] datarsp = new Object[lstrsp.size()][2];
        
        int mysize = 0;
        for (Resep rsp:lstrsp){
            datarsp[mysize][0]=rsp.getId_resep();
            datarsp[mysize][1]=rsp.getId_pemeriksaan();
            mysize++;
        }
        return datarsp;
    }
    
    public Object[][] getResep3(){
        Execute exe = new Execute();
        List<Resep>lstrsp = exe.ListResep_bayar2();
        Object[][] datarsp = new Object[lstrsp.size()][2];
        
        int mysize = 0;
        for (Resep rsp:lstrsp){
            datarsp[mysize][0]=rsp.getId_resep();
            datarsp[mysize][1]=rsp.getId_pemeriksaan();
            mysize++;
        }
        return datarsp;
    }
    
    public Object[][] getResep_ListObat(String id_resep){
        Execute exe = new Execute();
        List<Resep_Item>lstrsp_itm = exe.ListResep_Item(id_resep);
        Object[][] datarsp_item = new Object[lstrsp_itm.size()][2];
        
        int mysize = 0;
        for (Resep_Item rsp_item:lstrsp_itm){
            datarsp_item[mysize][0]=rsp_item.getId_resep();
            datarsp_item[mysize][1]=rsp_item.getId_obat();
            mysize++;
        }
        return datarsp_item;
    }    
    
    public Object[][] getListObat(String id1){
        Execute exe = new Execute();
        List<Obat>lst_obat = exe.ListObat(id1);
        Object[][] dataobt = new Object[lst_obat.size()][3];
        
        int mysize = 0;
        for (Obat obt:lst_obat){
            dataobt[mysize][0]=obt.getId_obat();
            dataobt[mysize][1]=obt.getNama();
            dataobt[mysize][2]=obt.getHarga();
            mysize++;
        }
        return dataobt;
    }    
    
}
