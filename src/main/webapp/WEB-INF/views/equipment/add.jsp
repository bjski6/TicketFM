
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Dodaj urządzenie</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">
<form:form method="post" modelAttribute="equipment" action="/equipment/add">
    <%--@declare id="installation""--%><p hidden><form:input path="id" id="id"/></p>

    <label for="name">Nazwa</label>
    <form:input path="name" id="name"/>
    <form:errors path="name" cssClass="error"/>
    <br>
    <label for="model">Model</label>
    <form:input path="model" id="model"/>
    <form:errors path="model" cssClass="error"/>
    <br>
    <label for="serialNo">Numer seryjny</label>
    <form:input path="serialNo" id="serialNo"/>
    <form:errors path="serialNo" cssClass="error"/>
    <br>
    <label for="manufacturer">Producent</label>
    <form:input path="manufacturer" id="manufacturer"/>
    <form:errors path="manufacturer" cssClass="error"/>
    <br>
    <label for="status">Status urządzenia</label>
    <form:select path="status" items="${status}"/>
    <form:errors path="status" cssClass="error"/>
    <br>
    <label for="installation">System</label>
    <form:select itemValue="id" itemLabel="name"
                 path="installation.id" items="${installations}"/>
    <form:errors path="installation" cssClass="error"/>
    <br>

    <input type="submit" value="Dodaj">
</form:form>

<%@ include file="../footer.jsp" %>