package koperasi.entity;
// Generated 15-May-2019 14:24:01 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pinjaman generated by hbm2java
 */
public class Pinjaman  implements java.io.Serializable {


     private Integer idpinjaman;
     private User user;
     private String jumlahpinjaman;
     private Integer jumlahcicilan;
     private Date tanggalpinjam;

    public Pinjaman() {
    }

    public Pinjaman(User user, String jumlahpinjaman, Integer jumlahcicilan, Date tanggalpinjam) {
       this.user = user;
       this.jumlahpinjaman = jumlahpinjaman;
       this.jumlahcicilan = jumlahcicilan;
       this.tanggalpinjam = tanggalpinjam;
    }
   
    public Integer getIdpinjaman() {
        return this.idpinjaman;
    }
    
    public void setIdpinjaman(Integer idpinjaman) {
        this.idpinjaman = idpinjaman;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getJumlahpinjaman() {
        return this.jumlahpinjaman;
    }
    
    public void setJumlahpinjaman(String jumlahpinjaman) {
        this.jumlahpinjaman = jumlahpinjaman;
    }
    public Integer getJumlahcicilan() {
        return this.jumlahcicilan;
    }
    
    public void setJumlahcicilan(Integer jumlahcicilan) {
        this.jumlahcicilan = jumlahcicilan;
    }
    public Date getTanggalpinjam() {
        return this.tanggalpinjam;
    }
    
    public void setTanggalpinjam(Date tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }




}


