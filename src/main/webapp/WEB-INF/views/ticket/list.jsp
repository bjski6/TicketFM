<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Lista Zgłoszeń</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <table border="2">
                    <thead>
                    <th>Nr</th>
                    <th>Temat</th>
                    <th>Typ zgłoszenia</th>
                    <th>System</th>
                    <th>Status</th>
                    <th>Data dodania</th>
                    <th>Planowana data wyk.</th>
                    <th>Odpowiedzialny</th>

                    </thead>
                    <tbody>
                    <c:forEach items="${tickets}" var="ticket">
                        <tr>
                            <td><c:out value="${ticket.id}"/></td>
                            <td><c:out value="${ticket.subject}"/></td>
                            <td><c:out value="${ticket.ticketType}"/></td>
                            <td><c:out value="${ticket.installationTicket}"/></td>
                            <td><c:out value="${ticket.status}"/></td>
                            <td><c:out value="${ticket.dateAddString}"/></td>
                            <td><c:out value="${ticket.plannedFinishDateString}"/></td>
                            <td><c:out value="${ticket.personResponsibleTicket.getNameAndSurname()}"/></td>

                            <td><a href="details/${ticket.id}"><input type="button" value="Szczegóły"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<%@ include file="../footer.jsp" %>