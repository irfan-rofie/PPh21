/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import spring.pph21.model.Transaksi;

/**
 *
 * @author labprog1_7
 */
public class TransaksiDaoImpl extends HibernateDaoSupport implements TransaksiDao {

    @Override
    public void saveTransaksi(Transaksi trx) {
        getHibernateTemplate().saveOrUpdate(trx);
    }

    @Override
    public void deleteTransaksi(String nik) {
        getHibernateTemplate().delete(getTransaksi(nik));
    }

    @Override
    public Transaksi getTransaksi(String nik) {
        return (Transaksi) getHibernateTemplate().get(Transaksi.class, nik);
    }

}