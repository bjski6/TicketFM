<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Edytuj</h1></div>
            </div>
        </div><!-- /.container-fluid -->
    </section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <form:form method="post" modelAttribute="ticket" action="/ticket/edited">
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

                <label for="status">Status zgłoszenia</label>
                    <form:select itemValue="id" itemLabel="status"
                                 path="status.id" items="${statusList}"/>
                    <form:errors path="status" cssClass="error"/>
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
                    <form:input path="description" id="description"/>
                    <form:errors path="description" cssClass="error"/>
                <br>

                    <label for="personResponsibleTicket">Odpowiedzialny </label>
                        <form:select itemValue="id" itemLabel="nameAndSurname"
                                     path="personResponsibleTicket.id" items="${personList}"/>
                        <form:errors path="personResponsibleTicket" cssClass="error"/>
                    <br>

                <label for="plannedFinishDateString">Planowana data wyk.</label>
                    <form:input path="plannedFinishDateString" id="plannedFinishDateString" placeholder="DD.MM.YYYY HH:MM"/>
                    <form:errors path="plannedFinishDateString" cssClass="error"/>
                <br>

                <input type="submit" value="Dodaj">
                </form:form>


<%@include file="../footer.jsp" %>