package koperasi.entity;
// Generated 15-May-2019 14:24:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer iduser;
     private String nama;
     private String email;
     private String username;
     private String password;
     private Integer role;
     private Set angsurans = new HashSet(0);
     private Set simpanans = new HashSet(0);
     private Set transaksis = new HashSet(0);
     private Set pinjamans = new HashSet(0);

    public User() {
    }

    public User(String nama, String email, String username, String password, Integer role, Set angsurans, Set simpanans, Set transaksis, Set pinjamans) {
       this.nama = nama;
       this.email = email;
       this.username = username;
       this.password = password;
       this.role = role;
       this.angsurans = angsurans;
       this.simpanans = simpanans;
       this.transaksis = transaksis;
       this.pinjamans = pinjamans;
    }
   
    public Integer getIduser() {
        return this.iduser;
    }
    
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getRole() {
        return this.role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }
    public Set getAngsurans() {
        return this.angsurans;
    }
    
    public void setAngsurans(Set angsurans) {
        this.angsurans = angsurans;
    }
    public Set getSimpanans() {
        return this.simpanans;
    }
    
    public void setSimpanans(Set simpanans) {
        this.simpanans = simpanans;
    }
    public Set getTransaksis() {
        return this.transaksis;
    }
    
    public void setTransaksis(Set transaksis) {
        this.transaksis = transaksis;
    }
    public Set getPinjamans() {
        return this.pinjamans;
    }
    
    public void setPinjamans(Set pinjamans) {
        this.pinjamans = pinjamans;
    }




}


