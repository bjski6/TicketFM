<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Edytuj użytkownika</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="person" action="/user/edited">
                <p hidden><form:input path="id" id="id"/></p>
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
                    <label for="companyPerson">Firma</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="companyPerson.id" items="${companyList}"/>
                    <form:errors path="companyPerson" cssClass="error"/>
                    <br>
                    <label for="password">Hasło</label>
                    <form:input path="password" id="password"/>
                    <form:errors path="password" cssClass="error"/>
                    <br>
                    <label for="phoneNumber">Numer telefonu</label>
                    <form:input path="phoneNumber" id="phoneNumber"/>
                    <form:errors path="phoneNumber" cssClass="phoneNumber"/>
                    <br>
                    <input type="submit" value="Zapisz">
                    <br>
                </form:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>

