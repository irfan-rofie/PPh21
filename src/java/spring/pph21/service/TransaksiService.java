/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.service;

import spring.pph21.model.Transaksi;

/**
 *
 * @author labprog1_7
 */
public interface TransaksiService {

    public void saveTransaksi(Transaksi trx);

    public Transaksi getTransaksi(String nik);

    public void deleteTransaksi(String nik);
}
