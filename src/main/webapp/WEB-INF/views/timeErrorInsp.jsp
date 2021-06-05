<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <style>
    .error {
      color: red;
    }
  </style>
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
    <div class="card-body login-card-body"><p class="login-box-msg">
      <td>Wprowadź datę w wymaganym formacie</td>
      <br>
      </p>

      <div class="row" >
        <div class="col-4">
          <a href="/inspection/generate"> <button type="submit" class="btn btn-block btn-danger">OK</button></a>
        </div><!-- /.col -->
      </div>

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
</div>
</body>
</html>

