<%-- 
    Document   : InputPegawai
    Created on : Jun 3, 2014, 5:58:38 AM
    Author     : labprog1_7
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
            <form method="post" action="transaksi.htm">
                <table>
                    <caption><c:out value="${title}"></c:out></caption>
                        <tr>
                            <td>NIK</td>
                            <td>:</td>
                            <td><input type="text" name="nik" maxlength="10" value="${pegawai.nik}"></td>
                        </tr>
                        <tr>
                            <td>Nama</td>
                            <td>:</td>
                            <td><input type="text" name="nama" maxlength="25" value="${pegawai.nama}"></td>
                    </tr>
                    <tr>
                        <td>Alamat</td>
                        <td>:</td>
                        <td><textarea name="alamat" maxlength="50">${pegawai.alamat}</textarea></td>
                    </tr>
                    <tr>
                        <td>Jabatan</td>
                        <td>:</td>
                        <td>
                            <select name="jabatan">
                                <option value="programmer"<c:if test="${pegawai.jabatan=='programmer'}">selected</c:if>>Programmer</option>
                                <option value="analis"<c:if test="${pegawai.jabatan=='analis'}">selected</c:if>>Analis</option>
                                <option value="designer"<c:if test="${pegawai.jabatan=='designer'}">selected</c:if>>Designer</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td>:</td>
                            <td>
                                <input type="radio" name="status" value="menikah"<c:if test="${pegawai.status=='menikah'}">checked</c:if>>Menikah
                            <input type="radio" name="status" value="belum"<c:if test="${pegawai.status=='belum'}">checked</c:if>>Belum Menikah
                            </td>
                        </tr>
                        <tr>
                            <td>Jumlah Anak</td>
                            <td>:</td>
                            <td><input type="text" name="jumlahAnak" maxlength="2" width="5px" value="${pegawai.jumlahAnak}"></td>
                    </tr>
                    <tr>
                        <td>Gaji</td>
                        <td>:</td>
                        <td><input type="text" name="gaji" maxlength="10" value="${pegawai.gaji}"></td>
                    </tr>
                    <tr>
                        <td>Iuran Pensiun</td>
                        <td>:</td>
                        <td><input type="text" name="iuranPensiun" maxlength="6" value="${pegawai.iuranPensiun}"></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="kirim">
                            <input type="button" value="Kembali" onclick="back()">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
