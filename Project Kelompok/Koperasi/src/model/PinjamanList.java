/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class PinjamanList {
    int no, jumlahCicilan;
    String namaPeminjam, jumlahPinjaman;
    Date TanggalPinjaman;

    public PinjamanList(int no, String namaPeminjam, String jumlahPinjaman, int jumlahCicilan, Date TanggalPinjaman) {
        this.no = no;
        this.namaPeminjam = namaPeminjam;
        this.jumlahPinjaman = jumlahPinjaman;
        this.jumlahCicilan = jumlahCicilan;
        this.TanggalPinjaman = TanggalPinjaman;
    }

    public PinjamanList() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(String jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public int getJumlahCicilan() {
        return jumlahCicilan;
    }

    public void setJumlahCicilan(int jumlahCicilan) {
        this.jumlahCicilan = jumlahCicilan;
    }

    public Date getTanggalPinjaman() {
        return TanggalPinjaman;
    }

    public void setTanggalPinjaman(Date TanggalPinjaman) {
        this.TanggalPinjaman = TanggalPinjaman;
    }
    
    
}
