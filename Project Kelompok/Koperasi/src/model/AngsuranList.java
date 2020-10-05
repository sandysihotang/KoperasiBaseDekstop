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
public class AngsuranList {
    int no;
    String nama, jumlahAngsuran;
    Date TanggalAngsuran;

    public AngsuranList(int no, String nama, String jumlahAngsuran, Date TanggalAngsuran) {
        this.no = no;
        this.nama = nama;
        this.jumlahAngsuran = jumlahAngsuran;
        this.TanggalAngsuran = TanggalAngsuran;
    }

    public AngsuranList() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlahAngsuran() {
        return jumlahAngsuran;
    }

    public void setJumlahAngsuran(String jumlahAngsuran) {
        this.jumlahAngsuran = jumlahAngsuran;
    }

    public Date getTanggalAngsuran() {
        return TanggalAngsuran;
    }

    public void setTanggalAngsuran(Date TanggalAngsuran) {
        this.TanggalAngsuran = TanggalAngsuran;
    }
    
    
    
}
