<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Nowe zgłoszenie</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="ticket" action="/ticket/add">
                    <p hidden><form:input path="id" id="id"/></p>
                    <label for="companyTickets">Firma</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="companyTicket.id" items="${companyList}"/>
                    <form:errors path="companyTicket" cssClass="error"/>
                    <br>
                    <label for="ticketType">Typ zgłoszenia</label>
                    <form:select itemValue="id" itemLabel="ticketType"
                                 path="ticketType.id" items="${ticketTypeList}"/>
                    <form:errors path="ticketType" cssClass="error"/>
                    <br>
                    <label for="installationTicket">System</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="installationTicket.id" items="${installationList}"/>
                    <form:errors path="installationTicket" cssClass="error"/>
                    <br>
                    <label for="subject">Temat</label>
                    <form:input path="subject" id="subject"/>
                    <form:errors path="subject" cssClass="error"/>
                    <br>
                    <label for="description">Opis zgłoszenia</label>
                    <form:input path="description" id="description" class="form-control" rows="4" col="4"/>
                    <form:errors path="description" cssClass="error"/>
                    <br>
                    <label for="plannedFinishDate">Planowana data wyk.</label>
                    <form:input type="date" path="plannedFinishDate" id="plannedFinishDate"/>
                    <form:errors path="plannedFinishDate" cssClass="error"/>
                    <br>
                    <input type="submit" value="Dodaj">
                </form:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>

