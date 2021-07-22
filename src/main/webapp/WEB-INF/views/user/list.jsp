<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
                    <h1>Użytkownicy</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <table border="2">
                    <thead>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Nr telefonu</th>
                    <th>Firma</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${people}" var="user">
                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.phoneNumber}"/></td>
                            <td><c:out value="${user.companyPerson}"/></td>
                            <td><a href="edit/${user.id}"><input type="button" value="Edytuj"></a></td>
                            <td><a href="delete/${user.id}"> <input type="button" value="Usuń użytkownika"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <td><a href="../user/add"><input type="button" value="Dodaj nowego użytkownika"></a></td>
                </table>
            </div>
        </div>
    </section>
</div>
</body>
</html>

