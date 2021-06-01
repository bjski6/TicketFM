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


                <table border="2">
                    <thead>
                    <th>Nazwa Firmy</th>
                    <th>Typ</th>
                    </thead>
                    <tbody>

                    <c:forEach items="${company}" var="company">
                    <tr>
                        <td><c:out value="${company.name}"/></td>
                        <td><c:out value="${company.companyType}"/></td>
                        <td><a href="delete/${company.id}">Usuń</a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div><!-- /.card-body -->
            <div class="card-footer">
                <li class="nav-item has-treeview"><a href="/company/add" class="nav-link">
                    <i class="nav-icon fas fa-copy"></i>
                    <p>Dodaj </p></a>
            </div><!-- /.card-footer--></div><!-- /.card --></section>
    <!-- /.content --></div>
<!-- /.content-wrapper -->
<footer class="main-footer">
    <div class="float-right d-none d-sm-block">
</footer>
<!-- Control Sidebar -->
<!-- Control sidebar content goes here --><!-- /.control-sidebar -->
</div>
<!-- ./wrapper --><!-- jQuery -->

<%@ include file="../footer.jsp" %>