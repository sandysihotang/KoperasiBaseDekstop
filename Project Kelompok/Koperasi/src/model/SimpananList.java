/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class SimpananList {
    int no;
    String nama;
    String jumlahsimpanan;

    public SimpananList(int no, String nama, String jumlahsimpanan) {
        this.no = no;
        this.nama = nama;
        this.jumlahsimpanan = jumlahsimpanan;
    }

    public SimpananList() {
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

    public String getJumlahsimpanan() {
        return jumlahsimpanan;
    }

    public void setJumlahsimpanan(String jumlahsimpanan) {
        this.jumlahsimpanan = jumlahsimpanan;
    }
    
    
}
