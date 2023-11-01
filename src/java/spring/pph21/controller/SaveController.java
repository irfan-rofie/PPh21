/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import spring.pph21.model.Pegawai;
import spring.pph21.model.Transaksi;
import spring.pph21.service.PegawaiService;
import spring.pph21.service.TransaksiService;

/**
 *
 * @author Irfan Rofie
 */
public class SaveController extends AbstractCommandController {

    private PegawaiService pegawaiService;
    private TransaksiService transaksiService;

    public void setPegawaiService(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    public void setTransaksiService(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    public SaveController() {
        this.setCommandClass(Pegawai.class);
    }

    public SaveController(Class commandClass) {
        this.setCommandClass(Transaksi.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse hsr1, Object o, BindException be) throws Exception {
        Map map = new HashMap();
        try {
            Pegawai pegawai = (Pegawai) o;
            pegawai.setPerusahaan(Pegawai.FEDORA);
            pegawai.setGaji(Long.parseLong(request.getParameter("gaji")));
            pegawai.setJumlahAnak(Integer.parseInt(request.getParameter("jumlahAnak")));
            pegawai.setBiayaJabatan((long) (Pegawai.TUNJANGAN * pegawai.getGaji()));
            if (pegawai.getBiayaJabatan() > 500000) {
                pegawai.setBiayaJabatan(500000);
            }
            if (pegawai.getStatus().contains("belum")) {
                pegawai.setJumlahAnak(0);
            }
            pegawai.setIuranPensiun(Long.parseLong(request.getParameter("iuranPensiun")));
            pegawaiService.savePegawai(pegawai);
            Pegawai pg = pegawaiService.getPegawai(pegawai.getNik());
            Transaksi trx = new Transaksi();
            trx.setNik(pg.getNik());
            trx.setPengurang(pg.getBiayaJabatan() + pg.getIuranPensiun());
            trx.setGajiBersihSebelumPajak(pg.getGaji() - trx.getPengurang());
            trx.setPPhNettoPerTahun(Transaksi.TAHUN * trx.getGajiBersihSebelumPajak());
            if (pg.getStatus().contains("belum")) {
                trx.setPtkp(Transaksi.WAJIB_PAJAK);
            } else {
                if (pg.getJumlahAnak() >= 3) {
                    trx.setPtkp((Transaksi.WAJIB_PAJAK + Transaksi.TANGGUNGAN) + (3 * (Transaksi.TANGGUNGAN)));
                } else if (pg.getJumlahAnak() == 2) {
                    trx.setPtkp((Transaksi.WAJIB_PAJAK + Transaksi.TANGGUNGAN) + (2 * (Transaksi.TANGGUNGAN)));
                } else if (pg.getJumlahAnak() == 1) {
                    trx.setPtkp((Transaksi.WAJIB_PAJAK + Transaksi.TANGGUNGAN) + Transaksi.TANGGUNGAN);
                } else {
                    trx.setPtkp(Transaksi.WAJIB_PAJAK + Transaksi.TANGGUNGAN);
                }
            }
            if (trx.getPPhNettoPerTahun() > trx.getPtkp()) {
                trx.setPkp(trx.getPPhNettoPerTahun() - trx.getPtkp());
                if (trx.getPPhNettoPerTahun() <= 50000000) {
                    trx.setPPhPerTahun((long) (0.05 * trx.getPkp()));
                } else if (trx.getPPhNettoPerTahun() <= 250000000) {
                    trx.setPPhPerTahun((long) (0.15 * trx.getPkp()));
                } else if (trx.getPPhNettoPerTahun() <= 500000000) {
                    trx.setPPhPerTahun((long) (0.25 * trx.getPkp()));
                } else {
                    trx.setPPhPerTahun((long) (0.3 * trx.getPkp()));
                }
                trx.setPPhPerBulan(trx.getPPhPerTahun() / Transaksi.TAHUN);
                trx.setGajiBersihSetelahPajak(trx.getGajiBersihSebelumPajak() - trx.getPPhPerBulan());
            } else {
                trx.setPkp(0);
                trx.setPPhPerTahun(0);
                trx.setPPhPerBulan(0);
                trx.setGajiBersihSetelahPajak(trx.getGajiBersihSebelumPajak());
            }
            transaksiService.saveTransaksi(trx);
            PagedListHolder pagedListHolder = (PagedListHolder) request.getSession().getAttribute("pegawaiList");
            pagedListHolder = new PagedListHolder(pegawaiService.viewPegawai());
            String page = request.getParameter("page");
            if ("next".equals(page)) {
                pagedListHolder.nextPage();
            } else if ("previous".equals(page)) {
                pagedListHolder.previousPage();
            }
            pagedListHolder.setPageSize(5);
            request.getSession().setAttribute("pegawaiList", pagedListHolder);
            map.put("jumlah", pegawaiService.getJumlahPegawai());
            map.put("pegawai", pagedListHolder);
            map.put("url", "ViewPegawai.jsp");
        } catch (NumberFormatException e) {
        }
        return new ModelAndView("index", map);
    }
}
