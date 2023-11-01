/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author labprog1_7
 */
@Entity
@Table(name = "trx_hitung")
public class Transaksi implements Serializable {

    @Id
    @Column(name = "nik")
    private String nik;
    @Column(name = "pengurang")
    private long pengurang;
    @Column(name = "gajiBersihSebelumPajak")
    private long gajiBersihSebelumPajak;
    @Column(name = "PPhNettoPerTahun")
    private long PPhNettoPerTahun;
    @Column(name = "ptkp")
    private long ptkp;
    @Column(name = "pkp")
    private long pkp;
    @Column(name = "PPhPerTahun")
    private long PPhPerTahun;
    @Column(name = "PPhPerBulan")
    private long PPhPerBulan;
    @Column(name = "gajiBersihSetelahPajak")
    private long gajiBersihSetelahPajak;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public long getPengurang() {
        return pengurang;
    }

    public void setPengurang(long pengurang) {
        this.pengurang = pengurang;
    }

    public long getGajiBersihSebelumPajak() {
        return gajiBersihSebelumPajak;
    }

    public void setGajiBersihSebelumPajak(long gajiBersihSebelumPajak) {
        this.gajiBersihSebelumPajak = gajiBersihSebelumPajak;
    }

    public long getPPhNettoPerTahun() {
        return PPhNettoPerTahun;
    }

    public void setPPhNettoPerTahun(long PPhNettoPerTahun) {
        this.PPhNettoPerTahun = PPhNettoPerTahun;
    }

    public long getPtkp() {
        return ptkp;
    }

    public void setPtkp(long ptkp) {
        this.ptkp = ptkp;
    }

    public long getPkp() {
        return pkp;
    }

    public void setPkp(long pkp) {
        this.pkp = pkp;
    }

    public long getPPhPerTahun() {
        return PPhPerTahun;
    }

    public void setPPhPerTahun(long PPhPerTahun) {
        this.PPhPerTahun = PPhPerTahun;
    }

    public long getPPhPerBulan() {
        return PPhPerBulan;
    }

    public void setPPhPerBulan(long PPhPerBulan) {
        this.PPhPerBulan = PPhPerBulan;
    }

    public long getGajiBersihSetelahPajak() {
        return gajiBersihSetelahPajak;
    }

    public void setGajiBersihSetelahPajak(long gajiBersihSetelahPajak) {
        this.gajiBersihSetelahPajak = gajiBersihSetelahPajak;
    }
    public static final long WAJIB_PAJAK = 15840000;
    public static final long TANGGUNGAN = 1320000;
    public static final int TAHUN = 12;
}
