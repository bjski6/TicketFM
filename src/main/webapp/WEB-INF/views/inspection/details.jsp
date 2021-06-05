<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Definicja przeglądu</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <table border="2">
                    <thead>
                    <th>Nr</th>
                    <th>Temat</th>
                    <th>Czas trwania (dni)</th>
                    <th>Typ (cykl)</th>
                    <th>System</th>
                    <th>Zgłaszający</th>
                    <th>Odpowiedzialny</th>
                    <th>Firma</th>

                    </thead>
                    <tbody>

                    <tr>

                        <td><c:out value="${inspection.id}"/></td>
                        <td><c:out value="${inspection.subject}"/></td>
                        <td><c:out value="${inspection.inspectionDuration}"/></td>
                        <td><c:out value="${inspection.inspectionCycle}"/></td>
                        <td><c:out value="${inspection.installationInspection}"/></td>
                        <td><c:out value="${inspection.ownerPerson}"/></td>
                        <td><c:out value="${inspection.inspectionResponsiblePerson.getNameAndSurname()}"/></td>
                        <td><c:out value="${inspection.inspectionCompany}"/></td>


                        <td><a href="/inspection/generate/${inspection.id}"><input type="button"
                                                                                   value="Dodaj nowe przeglądy"></a></td>
                    </tr>

                    </tbody>
                </table>

<%@ include file="../footer.jsp" %>