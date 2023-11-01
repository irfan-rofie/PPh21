/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import spring.pph21.model.Pegawai;

/**
 *
 * @author labprog1_7
 */
public class PegawaiDaoImpl extends HibernateDaoSupport implements PegawaiDao {

    @Override
    public void savePegawai(Pegawai pegawai) {
        getHibernateTemplate().saveOrUpdate(pegawai);
    }

    @Override
    public List viewPegawai() {
        return getHibernateTemplate().find("FROM Pegawai order by nik asc");
    }

    @Override
    public List getJumlahPegawai() {
        return getHibernateTemplate().find("select count(*) from Pegawai");
    }

    @Override
    public void hapusPegawai(String nik) {
        getHibernateTemplate().delete(getPegawai(nik));
    }

    @Override
    public Pegawai getPegawai(String nik) {
        return (Pegawai) getHibernateTemplate().get(Pegawai.class, nik);
    }

    @Override
    public List cariPegawai(String nik) {
        return getHibernateTemplate().find("FROM Pegawai WHERE nik LIKE '%" + nik + "%'");
    }

}
