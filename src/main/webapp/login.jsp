<%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 21-10-2024
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Horóscopo Chino - Inicio de Sesión</title>
    <style>
        .bg-custom-teal { background-color: #009688; }
        .btn-custom-teal { background-color: #009688; border-color: #009688; }
        .btn-custom-teal:hover { background-color: #00796b; border-color: #00796b; }
    </style>
    <script>
        // Función para mostrar alerta y redirigir al usuario a 'home.jsp'
        function mostrarMensajeExito() {
            var mensaje = "<%= request.getAttribute("successMessage") %>";
            if (mensaje !== "null" && mensaje !== "") {
                alert(mensaje);  // Mostrar ventana emergente con el mensaje
                // // Después de aceptar el mensaje, redirigir a home.jsp
                // window.location.href = "/home";
            }
        }
    </script>
</head>
<body onload="mostrarMensajeExito()">
<header class="bg-custom-teal text-white py-3">
    <div class="container d-flex align-items-center">
        <h5 class="mb-0 me-3">Horóscopo Chino</h5>
        <small class="text-light">Tu Horóscopo Chino</small>
    </div>
</header>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h4 class="mb-3">Inicia sesión</h4>
            <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("errorMessage") %>
            </div>
            <% } %>
            <p class="text-muted mb-4">Es necesario que inicies sesión para revisar tu horóscopo chino. Si todavía no tienes cuenta, haz click <a href="/registro">aquí</a>.</p>

            <form action="/login" method="post">
                <div class="row mb-3">
                    <label for="inputUsername" class="col-sm-4 col-form-label">Nombre de usuario:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="inputUsername" name="username" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPassword" class="col-sm-4 col-form-label">Contraseña:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="password" id="inputPassword" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-8 offset-sm-4">
                        <button type="submit" class="btn btn-custom-teal text-white">Ingresar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>