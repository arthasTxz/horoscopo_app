<%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 21-10-2024
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .bg-custom-teal { background-color: #009688; }
        .btn-custom-teal { background-color: #009688; border-color: #009688; }
        .btn-custom-teal:hover { background-color: #00796b; border-color: #00796b; }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h4 class="mb-3">Registrate</h4>


            <form action="/registro" method="post">
                <div class="row mb-3">
                    <label for="inputName" class="col-sm-4 col-form-label">Nombre:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="inputName" name="name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : " "%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="emailInput" class="col-sm-4 col-form-label">Correo electronico:</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" id="emailInput" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : " "%>" name="email" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputUsername" class="col-sm-4 col-form-label">Nombre de usuario:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="inputUsername" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : " "%>" name="username" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputFecha" class="col-sm-4 col-form-label">Fecha de Nacimiento:</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" id="inputFecha" name="fecha_nacimiento" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPassword" class="col-sm-4 col-form-label">Contraseña:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="inputPassword" name="password" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPasswordRepait" class="col-sm-4 col-form-label">Repita contraseña:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="inputPasswordRepait" name="password_repitida" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-8 offset-sm-4">
                        <button type="submit" class="btn btn-custom-teal text-white">Registrarse</button>
                    </div>
                </div>
            </form>
            <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("error") %>
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>
