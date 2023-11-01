<%-- 
    Document   : viewUser
    Created on : May 30, 2014, 11:40:20 PM
    Author     : bangkit
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
        <div id="anggota">
            <table  cellpadding="0" cellspacing="0">
                <tr>
                    <th colspan="6" align="center">Data Mahasiswa</th>
                </tr>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2"><a href="?aksi=view&proses=tambah">Tambah</a></th>
                </tr>
                <%int no = 1;%>
                <c:forEach var="user" items="${user}">
                    <%
                        String css = "";
                        css = (no % 2 == 0) ? "genap" : "ganjil";
                    %>
                    <tr id="<%=css%>">
                        <td><%=no++%></td>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td><a href="?aksi=view&proses=ubah&id=${user.id}">Ubah</a></td>
                        <td><a href="#" onclick="yes('?menu=crud&aksi=hapus&nim=')">Hapus</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
