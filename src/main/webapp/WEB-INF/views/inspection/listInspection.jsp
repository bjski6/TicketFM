<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Lista definicji</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <table border="2">
                    <thead>
                    <th>Nr</th>
                    <th>Temat</th>
                    <th>Status</th>
                    <th>Data przeglądu</th>
                    <th>Czas trwania (dni)</th>
                    <th>System</th>
                    <th>Zgłaszający</th>
                    <th>Data dodania</th>
                    <th>Odpowiedzialny</th>
                    <th>Firma</th>

                    </thead>
                    <tbody>
                    <c:forEach items="${inspections}" var="inspection">
                        <tr>
                            <td><c:out value="${inspection.id}"/></td>
                            <td><c:out value="${inspection.subject}"/></td>
                            <td><c:out value="${inspection.status}"/></td>
                            <td><c:out value="${inspection.startInspectionString}"/></td>
                            <td><c:out value="${inspection.inspectionDuration}"/></td>
                            <td><c:out value="${inspection.installationInspection}"/></td>
                            <td><c:out value="${inspection.ownerPerson}"/></td>
                            <td><c:out value="${inspection.dateAddString}"/></td>
                            <td><c:out value="${inspection.inspectionResponsiblePerson.getNameAndSurname()}"/></td>
                            <td><c:out value="${inspection.inspectionCompany}"/></td>
                            <td><a href="details/${inspection.id}">Szczegóły</a></td>
                        </tr>

                                <%--                            <td><a href="details/${ticket.id}">Szczegóły</a></td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

<%@ include file="../footer.jsp" %>