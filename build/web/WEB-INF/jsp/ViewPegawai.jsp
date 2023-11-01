<%-- 
    Document   : ViewPegawai
    Created on : Jun 3, 2014, 6:56:50 AM
    Author     : labprog1_7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function yes(ok) {
                if (confirm("Apa anda yakin akan menghapus data ini ?")) {
                    location.href = ok;
                }
            }
        </script>
    </head>
    <body>
        <div id="dat">
            <div id="jum">
                <form>
                    <table>
                        <tr>
                            <td>Jumlah Pegawai</td>
                            <td>:</td>
                            <td><input type="text" name="jumlah" value="${jumlah}" readonly></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div id="cari">
                <b>Pencarian berdasarkan</b>
                <select name="field">
                    <option value="#" selected disabled>- NIK -</option>
                </select>
                <form action="caripegawai.htm" method="post" name="cari">
                    <input type="text" name="nik">
                    <input type="submit" value="Cari">
                </form>
            </div>
        </div>
        <div id="tambah">
            <a href="pegawai.htm?aksi=tambah">Tambah</a>
        </div>
        <div id="anggota">
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <th>No</th>
                    <th>NIK</th>
                    <th>Nama</th>
                    <th>Jabatan</th>
                    <th>Gaji</th>
                    <th>Pengurang</th>
                    <th>PPh Pasal 21</th>
                    <th>Gaji Bersih Setelah Pajak</th>
                    <th colspan="3">Aksi</th>
                </tr>
                <% int no = 1, jum = 0;%>
                <c:forEach var="pegawai" items="${pegawai.pageList}">
                    <%
                        String css = "";
                        css = (no % 2 == 0) ? "genap" : "ganjil";
                    %>
                    <tr id="<%=css%>">
                        <%jum++;%>
                        <td><%=no++%></td>
                        <td>${pegawai.nik}</td>
                        <td>${pegawai.nama}</td>
                        <td>${pegawai.jabatan}</td>
                        <td>${pegawai.gaji}</td>
                        <td>${pegawai.transaksi.pengurang}</td>
                        <td>${pegawai.transaksi.PPhPerBulan}</td>
                        <td>${pegawai.transaksi.gajiBersihSetelahPajak}</td>
                        <td><a href="pegawai.htm?aksi=detail&nik=${pegawai.nik}" title="Detail"><img src="style/gambar/view_detail.png" width="20" height="20"></a></td>
                        <td><a href="pegawai.htm?aksi=ubah&nik=${pegawai.nik}" title="Ubah"><img src="style/gambar/Sample 7.png" width="20" height="20"></a></td>
                        <td><a href="#" title="Hapus" onclick="yes('pegawai.htm?aksi=hapus&nik=${pegawai.nik}')"><img src="style/gambar/Sample 3.png" width="20" height="20"></a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="11">
                        <c:if test="${!pegawai.firstPage}">
                            <a href="pegawai.htm?page=previous"><b>&lt;&lt; Prev</b></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${!pegawai.lastPage}">
                            <a href="pegawai.htm?page=next"><b>Next &gt;&gt;</b></a>
                        </c:if>
                        <c:if test="${status==1}">
                            <c:if test="<%=jum == 0%>">
                        <tr><td colspan="11"><b>Data Not Found</b></td></tr>
                    </c:if>
                    <tr><td colspan="11"><a href="viewpegawai.htm"><b>Back</b></a></td></tr>
                </c:if>
                </td>
                </tr>
            </table>
        </div>
    </body>
</html>
