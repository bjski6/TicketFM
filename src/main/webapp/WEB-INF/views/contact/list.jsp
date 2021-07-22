<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Kontakty</h1>
    </section>
    <section class="content">
        <div class="card card-solid">
            <div class="card-body pb-0">
                <div class="row d-flex align-items-stretch">
                    <c:forEach items="${people}" var="user">
                        <div class="col-20 col-sm-8 col-md-4 d-flex align-items-stretch">
                            <div class="card bg-light">
                                <div class="card-header text-muted border-bottom-0"></div>
                                <div class="card-body pt-0">
                                    <div class="row">
                                        <div class="col-10">
                                            <h2 class="lead"><b><c:out value="${user.name} ${user.surname}"/></b>
                                            </h2>
                                            <p class="text-muted text-sm"><b>Firma: </b><c:out
                                                    value="${user.companyPerson.name}"/></p>
                                            <ul class="ml-4 mb-0 fa-ul text-muted">
                                                <li class="small">
                                                    <span class="fa-li"><i class="fas fa-lg fa-building"></i></span>Email
                                                    <c:out value="${user.email}"/>
                                                </li>
                                                <li class="small"><span class="fa-li"><i class="fas fa-lg fa-phone"></i></span>Tel:
                                                    <c:out value="${user.phoneNumber}"/>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>

