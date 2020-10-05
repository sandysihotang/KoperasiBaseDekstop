package koperasi.entity;
// Generated 15-May-2019 14:24:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Barang generated by hbm2java
 */
public class Barang  implements java.io.Serializable {


     private Integer idbarang;
     private String nama;
     private String stok;
     private String harga;
     private String deskripsi;
     private Set transaksis = new HashSet(0);

    public Barang() {
    }

    public Barang(String nama, String stok, String harga, String deskripsi, Set transaksis) {
       this.nama = nama;
       this.stok = stok;
       this.harga = harga;
       this.deskripsi = deskripsi;
       this.transaksis = transaksis;
    }
   
    public Integer getIdbarang() {
        return this.idbarang;
    }
    
    public void setIdbarang(Integer idbarang) {
        this.idbarang = idbarang;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getStok() {
        return this.stok;
    }
    
    public void setStok(String stok) {
        this.stok = stok;
    }
    public String getHarga() {
        return this.harga;
    }
    
    public void setHarga(String harga) {
        this.harga = harga;
    }
    public String getDeskripsi() {
        return this.deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public Set getTransaksis() {
        return this.transaksis;
    }
    
    public void setTransaksis(Set transaksis) {
        this.transaksis = transaksis;
    }




}


