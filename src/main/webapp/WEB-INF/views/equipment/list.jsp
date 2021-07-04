<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Lista urządzeń</h1></div>
            </div>
        </div><!-- /.container-fluid --></section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="card-body">


                    <table border="2" >
                        <thead>
                        <th>Nazwa</th>
                        <th>Model</th>
                        <th>Numer seryjny</th>
                        <th>Producent</th>
                        <th>Status urządzenia</th>
                        <th>System</th>

                        </thead>
                        <tbody>
                        <c:forEach items="${equipments}" var="equipment">
                            <tr>
                                <td><c:out value="${equipment.name}"/></td>
                                <td><c:out value="${equipment.model}"/></td>
                                <td><c:out value="${equipment.serialNo}"/></td>
                                <td><c:out value="${equipment.manufacturer}"/></td>
                                <td><c:out value="${equipment.equipmentStatus}"/></td>
                                <td><c:out value="${equipment.installation}"/></td>
                                <td><a href="edit/${equipment.id}"><input type="button" value="Edytuj"></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

            </div>
        </div>
    </section>
<%@ include file="../footer.jsp" %>