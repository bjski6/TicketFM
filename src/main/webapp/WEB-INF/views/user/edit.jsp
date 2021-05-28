<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>


<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Edytuj użytkownika</h1></div>

            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <form:form method="post" modelAttribute="person" action="/user/edited">
                    <%--@declare id="installation""--%><p hidden><form:input path="id" id="id"/></p>

                    <label for="name">Imie</label>
                    <form:input path="name" id="name"/>
                    <form:errors path="name" cssClass="error"/>
                    <br>
                    <label for="surname">Nazwisko</label>
                    <form:input path="surname" id="surname"/>
                    <form:errors path="surname" cssClass="error"/>
                    <br>
                    <label for="email">email</label>
                    <form:input path="email" id="email"/>
                    <form:errors path="email" cssClass="error"/>
                    <br>
                    <label for="password">Hasło</label>
                    <form:input path="password" id="password"/>
                    <form:errors path="password" cssClass="error"/>
                    <br>
                    <label for="phoneNumber">Numer telefonu</label>
                    <form:input path="phoneNumber" id="phoneNumber"/>
                    <form:errors path="phoneNumber" cssClass="phoneNumber"/>
                    <br>

                    <input type="submit" value="Dodaj">
                    <br>


                </form:form>


<%@ include file="../footer.jsp" %>