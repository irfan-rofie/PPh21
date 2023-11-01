/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author bangkit
 */
@Entity
@Table(name = "pegawai")
public class Pegawai implements Serializable {

    @Id
    @Column(name = "nik")
    private String nik;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Transaksi transaksi; 
            
    @Column(name = "nama", nullable = false, length = 25)
    private String nama;
    @Column(name = "alamat", nullable = false, length = 50)
    private String alamat;
    @Column(name = "perusahaan", nullable = false, length = 25)
    private String perusahaan;
    @Column(name = "jabatan", nullable = false, length = 15)
    private String jabatan;
    @Column(name = "status", nullable = false, length = 15)
    private String status;
    @Column(name = "jumlahAnak", nullable = true)
    private int jumlahAnak;
    @Column(name = "gaji", nullable = false)
    private long gaji;
    @Column(name = "biayaJabatan", nullable = false)
    private long biayaJabatan;
    @Column(name = "iuranPensiun", nullable = false)
    private long iuranPensiun;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public long getGaji() {
        return gaji;
    }

    public void setGaji(long gaji) {
        this.gaji = gaji;
    }

    public long getBiayaJabatan() {
        return biayaJabatan;
    }

    public void setBiayaJabatan(long biayaJabatan) {
        this.biayaJabatan = biayaJabatan;
    }

    public long getIuranPensiun() {
        return iuranPensiun;
    }

    public void setIuranPensiun(long iuranPensiun) {
        this.iuranPensiun = iuranPensiun;
    }

    public static final double TUNJANGAN = 0.05;
    public static String FEDORA = "PT. Fedora";
}
