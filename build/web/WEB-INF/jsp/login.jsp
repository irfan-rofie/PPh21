<%-- 
    Document   : login
    Created on : May 27, 2014, 8:38:50 PM
    Author     : labprog1_7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="style/gambar/logo75.png">
        <link href="style/css/loginstyle.css" rel="stylesheet" type="text/css" />
        <title>Aplikasi PPh Pasal 21</title>
    </head>
    <body background="style/gambar/bg.gif">
        <div id="sis">
            <div id="hari"><script type="text/javascript" src="style/config/hari.js"></script></div>
            <div id="jam"><script type="text/javascript" src="style/config/jam.js"></script></div>
        </div>
        <div id="all">
            <div id="temp">
                <form method="post" action="user.htm">
                    <div id="judul">Login</div>
                    <b>Username</b><input type="password" name="username" autofocus required><br>
                    <b>Password</b><input type="password" name="password" required><br>
                    <input type="submit" value="masuk">
                </form>
            </div>
            <div id="pesan">                
                <iframe frameborder="0" name="isi">
            </div>
        </div>
        <div id="kak">
            Copyright&copy; Irfan Rofie
        </div>
    </body>
</html>
