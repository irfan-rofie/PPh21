/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.service;

import java.util.List;
import spring.pph21.dao.PegawaiDao;
import spring.pph21.model.Pegawai;

/**
 *
 * @author labprog1_7
 */
public class PegawaiServiceImpl implements PegawaiService {

    private PegawaiDao pegawaiDao;

    public void setPegawaiDao(PegawaiDao pegawaiDao) {
        this.pegawaiDao = pegawaiDao;
    }

    @Override
    public void savePegawai(Pegawai pegawai) {
        pegawaiDao.savePegawai(pegawai);
    }

    @Override
    public List viewPegawai() {
        return pegawaiDao.viewPegawai();
    }

    @Override
    public List getJumlahPegawai() {
        return pegawaiDao.getJumlahPegawai();
    }

    @Override
    public void hapusPegawai(String nik) {
        pegawaiDao.hapusPegawai(nik);
    }

    @Override
    public Pegawai getPegawai(String nik) {
        return pegawaiDao.getPegawai(nik);
    }

    @Override
    public List cariPegawai(String nik) {
        return pegawaiDao.cariPegawai(nik);
    }

}
