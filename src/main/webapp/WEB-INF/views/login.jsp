<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TicketFM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free/css/all.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/adminlte.min.css"/>">
    <script src="<c:url value="/resources/js/jquery/jquery.min.js"/>" defer></script>
    <script src="<c:url value="/resources/js/adminlte.min.js"/>" defer></script>
    <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo"><b>Ticket</b>FM</div>
    <div class="card">
        <div class="card-body login-card-body"><p class="login-box-msg">Zaloguj się</p>
            <form:form method="post" modelAttribute="person" action="login">
                <div class="input-group mb-3">
                    <input class="form-control" <form:input path="email" id="email" placeholder="EMAIL"/>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-envelope">
                        </span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input class="form-control" <form:input path="password" id="password" placeholder="HASŁO" type="password"/>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-lock"></span></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Zaloguj</button>
                    </div><!-- /.col -->
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

