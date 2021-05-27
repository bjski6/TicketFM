<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Dodaj aktualność</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">

            <form:form method="post" modelAttribute="news" action="/news/add">
    <p hidden><form:input path="id" id="id"/></p>

    <label for="subject">Tytuł</label>
    <form:input path="subject" id="subject"/>
    <form:errors path="subject" cssClass="error"/>

    <label for="content">Zawartość</label>
    <form:input path="content" id="content"/>
    <form:errors path="content" cssClass="error"/>
    <br>

    <input type="submit" value="Dodaj">
</form:form>

<!-- Page Wrapper -->

                <%@ include file="../footer.jsp" %>
