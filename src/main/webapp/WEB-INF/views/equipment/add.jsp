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
<html>
<style>
    .error{
        background-color: red;
    }
</style>
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.css"/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

Dodaj Urządzenie
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

<!-- Page Wrapper -->


</body>

</html>
