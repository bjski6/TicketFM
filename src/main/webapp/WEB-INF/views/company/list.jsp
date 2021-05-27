<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Lista firm</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">
                <table border="2">
                    <thead>
                    <th>Nazwa Firmy</th>
                    <th>Typ</th>

                    <c:forEach items="${company}" var="company">
                        <tr>
                            <td><c:out value="${company.name}"/></td>
                            <td><c:out value="${company.type}"/></td>

                            <td>Edytuj</a> </td>
                        </tr>
                    </c:forEach>
                    </thead>
                </table>

<%@ include file="../footer.jsp" %>