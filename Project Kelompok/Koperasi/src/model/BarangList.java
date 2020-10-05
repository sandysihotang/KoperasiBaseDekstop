/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class BarangList {
    int no;
    int idBarang;
    String nama;
    String stok;
    String harga;
    String deskripsi;

    public BarangList(int no, int idBarang, String nama, String stok, String harga, String deskripsi) {
        this.no = no;
        this.idBarang = idBarang;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public BarangList() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
