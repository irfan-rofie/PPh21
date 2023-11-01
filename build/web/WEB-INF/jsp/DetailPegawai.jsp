<%-- 
    Document   : DetailPegawai
    Created on : Jun 4, 2014, 4:05:06 PM
    Author     : Irfan Rofie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="crud">
            <table cellspacing="0">
                <caption><font color="red"><b>Laporan Gaji Pegawai ${pegawai.perusahaan}</b></font></caption>
                <tr id="ganjil">
                    <td><font color="red"><b>- NIK</b></font></td>
                    <td colspan="2"><font color="red"><b>${pegawai.nik}</b></font></td>
                </tr>
                <tr id="genap">
                    <td><font color="red"><b>- Nama</b></font></td>
                    <td colspan="2"><font color="red"><b>${pegawai.nama}</b></font></td>
                </tr>
                <tr id="ganjil">
                    <td colspan="2">- Gaji</td>
                    <td>${pegawai.gaji}</td>
                </tr>
                <tr id="genap">
                    <td colspan="3">- Pengurang :</td>
                </tr>
                <tr id="ganjil">
                    <td>&nbsp;&nbsp;1. Biaya Jabatan</td>
                    <td colspan="2">${pegawai.biayaJabatan}</td>
                </tr>
                <tr id="genap">
                    <td>&nbsp;&nbsp;2. Iuran Pensiun</td>
                    <td colspan="2">${pegawai.iuranPensiun}</td>
                </tr>
                <tr id="ganjil">
                    <td colspan="2">&nbsp;</td>
                    <td>(${pegawai.transaksi.pengurang})</td>
                </tr>
                <tr id="genap">
                    <td colspan="2">- Gaji Bersih Sebelum Pajak</td>
                    <td><font color="red">${pegawai.transaksi.gajiBersihSebelumPajak}</font></td>
                </tr>
                <tr id="ganjil">
                    <td colspan="3">- Penghasilan Netto Setahun :</td>
                </tr>
                <tr id="genap">
                    <td colspan="2">&nbsp;&nbsp;12 x ${pegawai.transaksi.gajiBersihSebelumPajak}</td>
                    <td>${pegawai.transaksi.PPhNettoPerTahun}</td>
                </tr>
                <tr id="ganjil">
                    <td colspan="3">- Penghasilan Tidak Kena Pajak :</td>
                </tr>
                <tr id="genap">
                    <td>&nbsp;&nbsp;1. Untuk Wajib Pajak Sendiri</td>
                    <td colspan="2">15840000</td>
                </tr>
                <tr id="ganjil">
                    <td>&nbsp;&nbsp;2. Untuk Wajib Pajak Menikah</td>
                    <td colspan="2"><c:if test="${pegawai.status=='menikah'}">1320000</c:if></td>
                    </tr>
                    <tr id="genap">
                        <td colspan="3">&nbsp;&nbsp;3. Untuk Wajib Pajak Anak : </td>
                    </tr>
                    <tr id="ganjil">
                    <c:if test="${pegawai.jumlahAnak>=3}">
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3 x 1320000</td>
                    </c:if>
                    <c:if test="${pegawai.jumlahAnak<3}">
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${pegawai.jumlahAnak} x 1320000</td>
                    </c:if>
                    <c:if test="${pegawai.jumlahAnak>=3}">
                        <td>3960000</td>
                        <td></td>
                    </c:if>
                    <c:if test="${pegawai.jumlahAnak==2}">
                        <td>2640000</td>
                        <td></td>
                    </c:if>
                    <c:if test="${pegawai.jumlahAnak==1}">
                        <td>1320000</td>
                        <td></td>
                    </c:if>
                    <c:if test="${pegawai.jumlahAnak==0}">
                        <td>0</td>
                        <td></td>
                    </c:if>
                </tr>
                <tr id="genap">
                    <td colspan="2"></td>
                    <td>(${pegawai.transaksi.ptkp})</td>
                </tr>
                <tr id="ganjil">
                    <td colspan="2">- Penghasilan Kena Pajak Setahun : </td>
                    <td><font color="red">${pegawai.transaksi.pkp}</font></td>
                </tr>
                <tr id="genap">
                    <td colspan="3">- Pajak Penghasilan Setahun : </td>
                </tr>
                <tr id="ganjil">
                    <c:if test="${pegawai.transaksi.PPhNettoPerTahun>500000000}">
                        <td>&nbsp;&nbsp;30% x ${pegawai.transaksi.pkp}</td>
                    </c:if>
                    <c:if test="${pegawai.transaksi.PPhNettoPerTahun>250000000}">
                        <td>&nbsp;&nbsp;25% x ${pegawai.transaksi.pkp}</td>
                    </c:if>
                    <c:if test="${pegawai.transaksi.PPhNettoPerTahun>500000000}">
                        <td>&nbsp;&nbsp;15% x ${pegawai.transaksi.pkp}</td>
                    </c:if>
                    <c:if test="${pegawai.transaksi.PPhNettoPerTahun<500000000}">
                        <td>&nbsp;&nbsp;5% x ${pegawai.transaksi.pkp}</td>
                    </c:if>
                    <td>${pegawai.transaksi.PPhPerTahun}</td>
                    <td></td>
                </tr>
                <tr id="genap">
                    <td colspan="3">- Pajak Penghasilan Pasal 21 : </td>
                </tr>
                <tr id="ganjil">
                    <td colspan="2">&nbsp;&nbsp;${pegawai.transaksi.PPhPerTahun} : 12</td>
                    <td>${pegawai.transaksi.PPhPerBulan}</td>
                </tr>
                <tr id="genap">
                    <td colspan="3">- Gaji Bersih Setelah Pajak : </td>
                </tr>
                <tr id="ganjil">
                    <td colspan="2">&nbsp;&nbsp;${pegawai.transaksi.gajiBersihSebelumPajak} - ${pegawai.transaksi.PPhPerBulan}</td>
                    <td>${pegawai.transaksi.gajiBersihSetelahPajak}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
