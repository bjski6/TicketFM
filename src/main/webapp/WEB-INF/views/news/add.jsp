<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Dodaj aktualność</h1>
    </section>
    <section class="content">
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="news" action="/news/add">
                    <div class="form-group">
                        <label for="subject">Temat</label>
                        <form:input path="subject" id="subject"/>
                        <form:errors path="subject" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="content">Treść</label>
                        <form:input path="content" id="content" class="form-control" rows="4" col="4"/>
                        <form:errors path="content" cssClass="error"/>
                    </div>
                    <input type="submit" value="Dodaj">
                </form:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>

