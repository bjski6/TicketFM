<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Przegląd</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="inspection" action="/inspection/add">
                    <p hidden><form:input path="id" id="id"/></p>
                    <label for="subject">Temat</label>
                    <form:input path="subject" id="subject"/>
                    <form:errors path="subject" cssClass="error"/>
                    <br>
                    <label for="inspectionCompany">Firma</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="inspectionCompany.id" items="${companyList}"/>
                    <form:errors path="inspectionCompany" cssClass="error"/>
                    <br>
                    <label for="installationInspection">System</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="installationInspection.id" items="${installationList}"/>
                    <form:errors path="installationInspection" cssClass="error"/>
                    <br>
                    <label for="inspectionResponsiblePerson">Odpowiedzialny</label>
                    <form:select itemValue="id" itemLabel="nameAndSurname"
                                 path="inspectionResponsiblePerson.id" items="${personList}"/>
                    <form:errors path="inspectionResponsiblePerson" cssClass="error"/>
                    <br>
                    <label for="inspectionCycle">Cykl</label>
                    <form:select itemValue="id" itemLabel="cycle"
                                 path="inspectionCycle.id" items="${inspectionCycleList}"/>
                    <form:errors path="inspectionCycle" cssClass="error"/>
                    <br>
                    <label for="startInspection">Data przeglądu</label>
                    <form:input path="startInspection" id="startInspection" type="date"/>
                    <form:errors path="startInspection" cssClass="error"/>
                    <br>
                    <label for="inspectionDuration">Czas trwania przeglądu (dni)</label>
                    <form:input type="number" path="inspectionDuration" id="inspectionDuration"/>
                    <form:errors path="inspectionDuration" cssClass="error"/>
                    <br>
                    <input type="submit" value="Dodaj">
                </form:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>

