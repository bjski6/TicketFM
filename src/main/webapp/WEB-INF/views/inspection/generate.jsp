<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Dodaj przeglądy</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="inspection" action="/inspection/generate">
                    <p hidden><form:input path="id" id="id"/></p>
                    <label for="startInspectionString">Początek cyklu</label>
                    <form:input path="startInspectionString" id="startInspectionString"/>
                    <form:errors path="startInspectionString" cssClass="error"/>
                    <br>
                    <label for="endInspectionString">Koniec cyklu</label>
                    <form:input path="endInspectionString" id="endInspectionString"/>
                    <form:errors path="endInspectionString" cssClass="error"/>
                    <br>
                    <p hidden>
                    <td>Cykl</td>
                    <c:out value="${inspection.inspectionCycle}"/>
                    <br>
                   <label for="subject">Temat</label>
                    <form:input path="subject" id="subject"/>
                    <form:errors path="subject" cssClass="error"/>
                    <br>
                    <label for="inspectionCompany">Firma</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="inspectionCompany.id" item="${inspectioncompanyList}"/>
                    <form:errors path="inspectionCompany" cssClass="error"/>
                    <br>
                    <label for="installationInspection">System</label>
                    <form:select itemValue="id" itemLabel="name"
                                 path="installationInspection.id" items="${installationList}"/>
                    <form:errors path="installationInspection" cssClass="error"/>
                    <br>
                    <label for="inspectionResponsiblePerson">Odpowiedzialny</label>
                    <form:select itemValue="id" itemLabel="nameAndSurname"
                                 path="inspectionResponsiblePerson.id" items="${userList}"/>
                    <form:errors path="inspectionResponsiblePerson" cssClass="error"/>
                    <br>
                    <label for="inspectionCycle">Cykl</label>
                    <form:select itemValue="id" itemLabel="cycle"
                                 path="inspectionCycle.id" items="${inspectionCycleList}"/>
                    <form:errors path="inspectionCycle" cssClass="error"/>
                    <br>
                    <label for="inspectionDuration">Czas trwania przeglądu</label>
                    <form:input path="inspectionDuration" id="inspectionDuration"/>
                    <form:errors path="inspectionDuration" cssClass="error"/>
                    <br>
                    </p>
                    <input type="submit" value="Generuj">
                </form:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>

