<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TicketFM</title><!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1"><!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>"><!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
    <!-- Google Font:Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini"><!-- Site wrapper -->
<div class="wrapper"><!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light"><!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="#" role="button">
                <i class="fas fa-bars"></i></a></li>
        </ul>
        <li class="nav-item d-none d-sm-inline-block">
        <li class="nav-item d-none d-sm-inline-block">
        </li>
        </ul><!-- SEARCH FORM -->
        <form class="form-inline ml-3">
            <div class="input-group input-group-sm">
                <div class="input-group-append">
                </div>
            </div>
        </form>
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" role="button">
            <a href="/logout">Wyloguj</a>
            <i class="fas fa-th-large"></i></a>

    </nav><!-- /.navbar --><!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4"><!-- Brand Logo -->
        <a href="../../index3.html"
           class="brand-link">
            <img src="<c:url value="/resources/dist/img/tfm.png"/>" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">TicketFM</span></a><!-- Sidebar -->
        <div class="sidebar"><!-- Sidebar user(optional) -->

            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class with font-awesome or any other icon font library -->
                    <li class="nav-item has-treeview"><a href="#" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>Start <i class="right fas fa-angle-left"></i></p></a>
                        <ul class="nav nav-treeview">
                            <%--                            <li class="nav-item" ><a href="/start/dashboard" class="nav-link"><i--%>
                            <%--                                    class="far fa-circle nav-icon"></i>--%>
                            <%--                                <p>Dashboard- zgłoszenia</p></a></li>--%>
                            <li class="nav-item"><a href="/news/list" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Aktualności</p></a></li>
                            <li class="nav-item"><a href="/start/contact/list" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Kontakty</p></a></li>
                        </ul>


                    <li class="nav-item has-treeview"><a href="/company/list" class="nav-link">
                        <i class="nav-icon fas fa-copy"></i>
                        <p>Firmy </p></a>

                    <li class="nav-item has-treeview"><a href="#" class="nav-link"><i class="nav-icon fas fa-tree"></i>
                        <p>Zgłoszenia <i class="fas fa-angle-left right"></i></p></a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item"><a href="/ticket/list" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Lista Zgłoszeń</p></a></li>
                            <li class="nav-item"><a href="/ticket/add" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Nowe zgłoszenie</p></a></li>
                        </ul>

                    <li class="nav-item has-treeview"><a href="#" class="nav-link"><i class="nav-icon fas fa-edit"></i>
                        <p>Przeglądy <i class="fas fa-angle-left right"></i></p></a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item"><a href="/inspection/list" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Definicje przeglądów</p></a></li>
                            <li class="nav-item"><a href="/inspection/add" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Nowa definicja</p></a></li>
                            <li class="nav-item"><a href="/inspection/listInspection" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Lista przeglądów</p></a></li>
                        </ul>

                    <li class="nav-item has-treeview"><a href="#" class="nav-link"><i class="nav-icon fas fa-table"></i>
                        <p>Urządzenia <i class="fas fa-angle-left right"></i></p></a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item"><a href="/equipment/list" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Lista urządzeń</p></a></li>

                            <li class="nav-item"><a href="/equipment/add" class="nav-link"><i
                                    class="far fa-circle nav-icon"></i>
                                <p>Nowe urządzenie</p></a></li>
                        </ul>

                    <li class="nav-item has-treeview"><a href="/user/list" class="nav-link"><i
                            class="nav-icon fas fa-book"></i>
                        <p>Użytkownicy</p></a></li>


                </ul>
            </nav>  <!-- /.sidebar-menu --></div><!-- /.sidebar --></aside>
    <!-- Content Wrapper. Contains page content -->
