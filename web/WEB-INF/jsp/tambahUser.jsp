<%-- 
    Document   : tambahUser
    Created on : May 30, 2014, 11:58:35 PM
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
        <div id="crud">
            <form method="post" action="?aksi=view&proses=tambah&kirim=kirim">
                <table>
                    <caption><c:out value="${update}" default="Tambah User"></c:out></caption>
                        <tr>
                            <td>Id</td>
                            <td>:</td>
                            <td><input type="text" name="id" value="${user.id}"></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>:</td>
                        <td><input type="text" name="username" value="${user.username}"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>:</td>
                        <td><input type="text" name="password" value="${user.password}"></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="kirim">
                            <input type="button" value="kembali" onclick="back()">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
