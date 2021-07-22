<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Dodaj firmę</h1>
    </section>
    <section class="content">
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
            </div>
        </div>
    </section>
</div>
</body>
</html>

