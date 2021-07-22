<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TicketFM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free/css/all.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/adminlte.min.css"/>">
    <script src="<c:url value="/resources/js/jquery/jquery.min.js"/>" defer></script>
    <script src="<c:url value="/resources/js/adminlte.min.js"/>" defer></script>
    <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button">
                    <i class="fas fa-bars"></i>
                </a>
            </li>
        </ul>
        <div id="logout">
            <a href="/logout">Wyloguj</a>
        </div>
    </nav>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="#" class="brand-link">
            <img src="<c:url value="/resources/img/tfm.png"/>"
                 class="brand-image img-circle elevation-3 myTheme-logo">
            <span class="brand-text font-weight-light">TicketFM</span>
        </a>
        <div class="sidebar">
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>Start <i class="right fas fa-angle-left"></i></p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/news/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Aktualności</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/contact/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Kontakty</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="/company/list" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>Firmy</p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tree"></i>
                            <p>Zgłoszenia <i class="fas fa-angle-left right"></i></p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/ticket/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Lista Zgłoszeń</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/ticket/add" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Nowe zgłoszenie</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>Przeglądy <i class="fas fa-angle-left right"></i></p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/inspection/add" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Nowy przegląd</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/inspection/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Lista przeglądów</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>Urządzenia <i class="fas fa-angle-left right"></i></p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/equipment/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Lista urządzeń</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/equipment/add" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Nowe urządzenie</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="/user/list" class="nav-link">
                            <i class="nav-icon fas fa-book"></i>
                            <p>Użytkownicy</p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- Content Wrapper. Contains page content -->
