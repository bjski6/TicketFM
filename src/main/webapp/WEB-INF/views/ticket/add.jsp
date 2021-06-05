<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Nowe zgłoszenie</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
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

                    <label for="plannedFinishDateString">Planowana data wyk.</label>
                    <form:input path="plannedFinishDateString" id="plannedFinishDateString" placeholder="DD.MM.YYYY HH:MM"/>
                    <form:errors path="plannedFinishDateString" cssClass="error"/>
                <br>

                <input type="submit" value="Dodaj">
                </form:form>

            </div><!-- /.card-body -->
            <!-- /.card-footer--></div><!-- /.card --></section>
    <!-- /.content --></div>
<!-- /.content-wrapper -->

<!-- Control sidebar content goes here --><!-- /.control-sidebar -->
</div>
<!-- ./wrapper --><!-- jQuery -->
<script src="<c:url value="/resources/plugins/jquery/jquery.min.js"/>"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/dist/js/adminlte.min.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/dist/js/demo.js"/>"></script>
</body>
</html>