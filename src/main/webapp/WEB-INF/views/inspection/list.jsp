<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Lista przeglądów</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <table border="2">
                    <thead>
                    <th>Nr</th>
                    <th>Temat</th>
                    <th>Data przeglądu</th>
                    <th>Czas trwania (dni)</th>
                    <th>System</th>
                    <th>Odpowiedzialny</th>
                    <th>Firma</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${inspections}" var="inspection">
                        <tr>
                            <td><c:out value="${inspection.id}"/></td>
                            <td><c:out value="${inspection.subject}"/></td>
                            <td><c:out value="${inspection.startInspection}"/></td>
                            <td><c:out value="${inspection.inspectionDuration}"/></td>
                            <td><c:out value="${inspection.installationInspection}"/></td>
                            <td><c:out value="${inspection.inspectionResponsiblePerson.getNameAndSurname()}"/></td>
                            <td><c:out value="${inspection.inspectionCompany}"/></td>
                            <td><a href="details/${inspection.id}"><input type="button" value="Szczegóły"></a></td>
                            <td><a href="edit/${inspection.id}"><input type="button" value="Edycja"></a></td>
                        </tr>
                        <%--                            <td><a href="details/${ticket.id}">Szczegóły</a></td>--%>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>
</body>
</html>

