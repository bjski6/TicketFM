<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 18.05.2021
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Dodaj firmę</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                <form:form method="post" modelAttribute="company" action="/company/add">
                <p hidden><form:input path="id" id="id"/></p>

                <label for="subject">Nazwa firmy</label>
                    <form:input path="name" id="name"/>
                    <form:errors path="name" cssClass="error"/>

                <label for="companyType">Typ firmy</label>
                    <form:select itemValue="id" itemLabel="companyType"
                                 path="companyType.id" items="${companyType}"/>
                    <form:errors path="companyType" cssClass="error"/>

                <input type="submit" value="Dodaj">
                </form:form>

<%@ include file="../footer.jsp" %>