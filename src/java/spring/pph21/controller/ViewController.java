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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import spring.pph21.service.PegawaiService;

/**
 *
 * @author Irfan Rofie
 */
public class ViewController implements Controller {

    private PegawaiService pegawaiService;

    public void setPegawaiService(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse hsr1) throws Exception {
        Map map = new HashMap();
        request.getSession().removeAttribute("pegawaiList");
        PagedListHolder pagedListHolder = (PagedListHolder) request.getSession().getAttribute("pegawaiList");
        if (pagedListHolder == null) {
            pagedListHolder = new PagedListHolder(pegawaiService.viewPegawai());
        } else {
            String page = request.getParameter("page");
            if ("next".equals(page)) {
                pagedListHolder.nextPage();
            } else if ("previous".equals(page)) {
                pagedListHolder.previousPage();
            }
        }
        pagedListHolder.setPageSize(5);
        request.getSession().setAttribute("pegawaiList", pagedListHolder);
        map.put("jumlah", pegawaiService.getJumlahPegawai());
        map.put("pegawai", pagedListHolder);
        map.put("url", "ViewPegawai.jsp");
        return new ModelAndView("index", map);
    }
}
