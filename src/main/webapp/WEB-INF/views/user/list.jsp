<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Użytkownicy</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">

                    <table border="2">
                        <thead>
                        <th>Imie</th>
                        <th>Nazwisko</th>
                        <th>email</th>
                        <th>Hasło</th>
                        <th>Nr telefonu</th>


                        </thead>
                        <tbody>
                        <c:forEach items="${people}" var="person">
                            <tr>
                                <td><c:out value="${person.name}"/></td>
                                <td><c:out value="${person.surname}"/></td>
                                <td><c:out value="${person.email}"/></td>
                                <td><c:out value="${person.password}"/></td>
                                <td><c:out value="${person.phoneNumber}"/></td>
                                <td><a href="edit/${person.id}"><input type="button" value="Edytuj"></a></td>
                                <td><a href="delete/${person.id}"> <input type="button" value="Usuń użytkownika"></a></td>

                            </tr>
                        </c:forEach>
                        </tbody>


<%@ include file="../footer.jsp" %>