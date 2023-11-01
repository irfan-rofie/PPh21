/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import spring.pph21.model.Pegawai;
import spring.pph21.service.PegawaiService;
import spring.pph21.service.TransaksiService;

/**
 *
 * @author labprog1_7
 */
public class PegawaiController implements Controller {

    private PegawaiService pegawaiService;
    private TransaksiService transaksiService;
    public HttpServletRequest request;

    public void setPegawaiService(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    public void setTransaksiService(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse hsr1) throws Exception {
        Map map = new HashMap();
//        PegawaiController pg = new PegawaiController();
        String aksi = request.getParameter("aksi");
        String nik = request.getParameter("nik");
        if (aksi == null) {
            PagedListHolder pagedListHolder = (PagedListHolder) request.getSession().getAttribute("pegawaiList");
            if (pagedListHolder == null) {
                pagedListHolder = new PagedListHolder(pegawaiService.viewPegawai());
            } else {
                String page = request.getParameter("page");
                switch (page) {
                    case "next":
                        pagedListHolder.nextPage();
                        break;
                    case "previous":
                        pagedListHolder.previousPage();
                        break;
                }
            }
            pagedListHolder.setPageSize(5);
            request.getSession().setAttribute("pegawaiList", pagedListHolder);
            map.put("jumlah", pegawaiService.getJumlahPegawai());
            map.put("pegawai", pagedListHolder);
            map.put("url", "ViewPegawai.jsp");
        } else if (aksi.contains("tambah")) {
            map.put("url", "InputPegawai.jsp");
            map.put("title", "Input Pegawai");
        } else if (aksi.contains("ubah")) {
            map.put("url", "InputPegawai.jsp");
            map.put("title", "Update Pegawai");
            map.put("pegawai", pegawaiService.getPegawai(nik));
        } else if (aksi.contains("detail")) {
            map.put("url", "DetailPegawai.jsp");
            map.put("pegawai", pegawaiService.getPegawai(nik));
        } else {
            pegawaiService.hapusPegawai(nik);
            transaksiService.deleteTransaksi(nik);
            map.put("url", "ViewPegawai.jsp");
            map.put("jumlah", pegawaiService.getJumlahPegawai());

            PagedListHolder pagedListHolder = (PagedListHolder) request.getSession().getAttribute("pegawaiList");

            List pegawaiList = pagedListHolder.getSource();
            for (Iterator iterator = pegawaiList.iterator(); iterator.hasNext();) {
                Pegawai pegawai = (Pegawai) iterator.next();
                if (pegawai.getNik().equals(nik)) {
                    pegawaiList.remove(pegawai);
                    break;
                }
            }
            pagedListHolder.setSource(pegawaiList);
            map.put("pegawai", pagedListHolder);            
        }
        return new ModelAndView("index", map);
    }

}
