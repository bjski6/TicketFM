<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Aktualności</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">

                    <table border="2">
                        <thead>
                        <th>Data dodania</th>
                        <th>Temat</th>
                        <th>Zawartość</th>
                        <th>Osoba dodająca</th>


                        </thead>
                        <tbody>
                        <c:forEach items="${news}" var="news">
                            <tr>
                                <td><c:out value="${news.dateString}"/></td>
                                <td><c:out value="${news.subject}"/></td>
                                <td><c:out value="${news.content}"/></td>
                                <td><c:out value="${news.personNews.getNameAndSurname()}"/></td>

                            </tr>
                        </c:forEach>
                        </tbody>



                </div><!-- /.card-body -->
                <div class="card-footer"><li class="nav-item has-treeview"><a href="/news/add" class="nav-link">
                    <i class="nav-icon fas fa-copy"></i>
                    <p>Dodaj </p></a></div><!-- /.card-footer--></div><!-- /.card --></section>
        <!-- /.content --></div><!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
    </footer><!-- Control Sidebar -->
    <!-- Control sidebar content goes here --><!-- /.control-sidebar -->
</div>
<!-- ./wrapper --><!-- jQuery -->

<%@ include file="../footer.jsp" %>
