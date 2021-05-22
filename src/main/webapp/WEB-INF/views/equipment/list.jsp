<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 18.05.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Equipment List</title>
</head>
<body>
<table border="2">
    <thead>
    <th>name</th>
    </thead>
    <tbody>
    <c:forEach items="${equipments}" var="equipment">
        <tr>
            <td><c:out value="${equipment.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
