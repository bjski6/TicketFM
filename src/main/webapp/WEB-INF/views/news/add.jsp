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
    <div class="col-md-6">
        <div class="card card-primary">
            <div class="card-header"><h3 class="card-title">Nowa aktualność</h3>
                <div class="card-tools">
                    <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip"
                            title="Collapse"><i class="fas fa-minus"></i></button>
                </div>
            </div>
            <div class="card-body"><form:form method="post" modelAttribute="news" action="/news/add">
                <div class="form-group"><label for="inputName">Temat</label>
                    <form:input path="subject" id="subject"/>
                    <form:errors path="subject" cssClass="error" class="form-control"/>
                </div>

                <div class="form-group"><label for="inputDescription">Treść</label>
                    <form:input path="content" id="content" class="form-control" rows="4" col="4"/>
                    <form:errors path="content" cssClass="error"/></div>
                <input type="submit" value="Dodaj">
            </form:form>

            </div><!-- /.card-body --></div><!-- /.card --></div>

    <%@ include file="../footer.jsp" %>
