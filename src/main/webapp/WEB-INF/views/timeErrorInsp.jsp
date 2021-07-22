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
    <%--    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">--%>
    <link rel="stylesheet" href="<c:url value="/resources/css/adminlte.min.css"/>">

    <!-- ./wrapper --><!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery/jquery.min.js"/>" defer></script>
    <!-- Bootstrap 4 -->
    <%--    <script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>" defer></script>--%>
    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/js/adminlte.min.js"/>" defer></script>
    <!-- AdminLTE for demo purposes -->
    <%--<script src="<c:url value="/resources/dist/js/demo.js"/>"></script>--%>
    <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
    <%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700">--%>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo"><b>Ticket</b>FM</div><!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body"><p class="login-box-msg">
            <td>Wprowadź datę w wymaganym formacie</td>
            <br>
            </p>

            <div class="row">
                <div class="col-4">
                    <a href="/inspection/generate">
                        <button type="submit" class="btn btn-block btn-danger">OK</button>
                    </a>
                </div><!-- /.col -->
            </div>

            <!-- /.login-card-body -->
        </div>
    </div><!-- /.login-box --><!-- jQuery -->

</div>
</body>
</html>

