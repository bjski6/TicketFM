<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Firmy</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">

                <table class="table table-striped projects">
                    <thead>
                    <tr>

                        <th style="width: 40%">Nazwa firmy</th>
                        <th style="width: 30%">Typ</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach items="${company}" var="company" >
                    <tr>

                        <td><c:out value="${company.name}"/></td>
                        <td><c:out value="${company.companyType}"/></td>
                        <td><a href="delete/${company.id}"><input type="button" value="Usuń"></a> </td>

                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div><!-- /.card-body -->
            <div class="card-header">
                <a href="/company/add" class="nav-link">
                    <input type="button" value="Dodaj firmę"></i>
                    </a>
            </div><!-- /.card-footer--></div><!-- /.card --></section>
    <!-- /.content --></div>
<!-- /.content-wrapper -->
<footer class="main-header">
    <div class="float-right d-none d-sm-block">
</footer>
<!-- Control Sidebar -->
<!-- Control sidebar content goes here --><!-- /.control-sidebar -->
</div>
<!-- ./wrapper --><!-- jQuery -->

<%@ include file="../footer.jsp" %>

