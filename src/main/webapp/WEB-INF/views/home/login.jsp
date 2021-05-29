<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TicketFM</title><!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1"><!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>"><!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
    <!-- Google Font:Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo"><b>Ticket</b>FM</div><!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body"><p class="login-box-msg">Zaloguj się</p>
            <form:form method="post" modelAttribute="person" action="/home/logged">
            <div class="input-group mb-3">
                <label for="email">Email</label>
                    <form:input path="email" id ="email"/>
                        <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-envelope"></span></div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <label for="password">Password</label>
                    <form:input path="password" id ="password"/>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-lock"></span></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Zaloguj</button>
                    </div><!-- /.col -->
                </div>
            </form:form>>

            <!-- /.login-card-body -->
        </div>
    </div><!-- /.login-box --><!-- jQuery -->
    <script src="<c:url value="/resources/plugins/jquery/jquery.min.js"/>"></script>
    <!-- Bootstrap 4 -->
    <script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/dist/js/adminlte.min.js"/>"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/resources/dist/js/demo.js"/>"></script>
</body>
</html>