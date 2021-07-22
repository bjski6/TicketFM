<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
                    <h1>Szczegóły zgłoszenia</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <table border="2">
                    <thead>
                    <th>Nr</th>
                    <th>Temat</th>
                    <th>Opis zgłoszenia</th>
                    <th>Typ zgłoszenia</th>
                    <th>System</th>
                    <th>Status</th>
                    <th>Firma</th>
                    <th>Zgłaszający</th>
                    <th>Data dodania</th>
                    <th>Planowana data wyk.</th>
                    <th>Odpowiedzialny</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td><c:out value="${ticket.id}"/></td>
                            <td><c:out value="${ticket.subject}"/></td>
                            <td><c:out value="${ticket.description}"/></td>
                            <td><c:out value="${ticket.ticketType}"/></td>
                            <td><c:out value="${ticket.installationTicket}"/></td>
                            <td><c:out value="${ticket.status}"/></td>
                            <td><c:out value="${ticket.companyTicket}"/></td>
                            <td><c:out value="${ticket.personTicket.getNameAndSurname()}"/></td>
                            <td><c:out value="${ticket.dateAdd}"/></td>
                            <td><c:out value="${ticket.plannedFinishDate}"/></td>
                            <td><c:out value="${ticket.personResponsibleTicket.getNameAndSurname()}"/></td>
                            <td><a href="/ticket/edit/${ticket.id}"><input type="button" value="Edytuj"></a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>
</body>
</html>

