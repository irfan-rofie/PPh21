/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.dao;

import java.util.List;
import spring.pph21.model.Pegawai;

/**
 *
 * @author labprog1_7
 */
public interface PegawaiDao {

    public void savePegawai(Pegawai pegawai);

    public List viewPegawai();

    public List getJumlahPegawai();

    public void hapusPegawai(String nik);

    public Pegawai getPegawai(String nik);

    public List cariPegawai(String nik);
}
