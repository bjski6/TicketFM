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
<head>
    <title>Title</title>
</head>
<body>
Equipment
<form:form method="post" modelAttribute="equipment" action="/equipment/add">
    <p hidden><form:input path="id" id="id" /></p>

    <label for= "name">name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>
    <br>
    <input type="submit" value="Dodaj">
</form:form>


</body>
</html>
