<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplikasi PPh Pasal 21 PT. Fedora</title>
    </head>
    <link rel="shortcut icon" href="style/gambar/logo75.png">
    <link rel="stylesheet" type="text/css" href="style/css/templete.css">
    <script type="text/javascript" src="style/config/jquery-1.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#all #menu a").click(function() {
                $("#all #menu a").removeClass("test");
                $(this).addClass("test");
            });
        });
    </script>
    <body background="style/gambar/bg.gif">

        <div id="all">
            <div id="head">
                <div id="hari">
                    <script type="text/javascript" src="style/config/hari.js"></script>
                </div>
                <div id="jam">
                    <script type="text/javascript" src="style/config/jam.js"></script>
                </div>
            </div>
            <div id="menu">
                <div id="judul"><img src="style/gambar/admin3.gif" id="men"></div>
                <a href="user.htm?aksi=beranda">Beranda</a>
                <a href="viewpegawai.htm">Pegawai</a>
                <a href="user.htm?aksi=keluar">Keluar</a>
            </div>
            <div id="content">
                <c:import url="${url}"></c:import>
            </div>
            <div id="kaki"></div>
        </div>

    </body>
</html>