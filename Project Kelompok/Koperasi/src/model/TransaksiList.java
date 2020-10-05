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
public class TransaksiList {
    int no;
    String namaBarang;
    String namaPemesan;
    String kodeTransaksi;
    int jumlahBarang;
    String totalHarga;

    public TransaksiList(int no, String namaBarang, String namaPemesan, String kodeTransaksi, int jumlahBarang, String totalHarga) {
        this.no = no;
        this.namaBarang = namaBarang;
        this.namaPemesan = namaPemesan;
        this.kodeTransaksi = kodeTransaksi;
        this.jumlahBarang = jumlahBarang;
        this.totalHarga = totalHarga;
    }

    public TransaksiList() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
}
