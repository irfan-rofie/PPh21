/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.service;

import spring.pph21.dao.TransaksiDao;
import spring.pph21.model.Transaksi;

/**
 *
 * @author labprog1_7
 */
public class TransaksiServiceImpl implements TransaksiService {

    private TransaksiDao transaksiDao;

    public void setTransaksiDao(TransaksiDao transaksiDao) {
        this.transaksiDao = transaksiDao;
    }

    @Override
    public void saveTransaksi(Transaksi trx) {
        transaksiDao.saveTransaksi(trx);
    }

    @Override
    public Transaksi getTransaksi(String nik) {
        return transaksiDao.getTransaksi(nik);
    }

    @Override
    public void deleteTransaksi(String nik) {
        transaksiDao.deleteTransaksi(nik);
    }

}
