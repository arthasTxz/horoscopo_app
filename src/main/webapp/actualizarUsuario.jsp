<%@ page import="com.edutecno.final_drilling.dto.UsuarioUpdateDTO" %><%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 21-10-2024
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="./asset/css/style.css">
    <script>
        // Función para mostrar alerta y redirigir al usuario a 'home.jsp'
        function mostrarMensajeExito() {
            var mensaje = "<%= request.getAttribute("successMessage") %>";
            if (mensaje !== "null") {
                alert(mensaje);  // Mostrar ventana emergente con el mensaje
                // Después de aceptar el mensaje, redirigir a home.jsp
                window.location.href = "/home";
            }
        }
    </script>
</head>
<body>
<%@include file="headerLogin.jsp"%>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h4 class="mb-3">Modificar datos</h4>

            <% UsuarioUpdateDTO usuarioUpdateDTO = (UsuarioUpdateDTO) request.getAttribute("usuario"); %>
            <form action="/modificarUsuario" method="post">
                <div class="row mb-3">
                    <label for="inputName" class="col-sm-4 col-form-label">Nombre:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" value="<%= usuarioUpdateDTO.getNombre()%>" id="inputName" name="name" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="emailInput" class="col-sm-4 col-form-label">Correo electronico:</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" id="emailInput" value="<%= usuarioUpdateDTO.getEmail()%>" name="email" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputUsername" class="col-sm-4 col-form-label">Nombre de usuario:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="inputUsername" value="<%= usuarioUpdateDTO.getUsername()%>" name="username" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputFecha" class="col-sm-4 col-form-label">Fecha de Nacimiento:</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" id="inputFecha" name="fecha_nacimiento" value="<%= usuarioUpdateDTO.getFechaNacimiento()%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPassword" class="col-sm-4 col-form-label">Contraseña:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="inputPassword" value="<%= usuarioUpdateDTO.getPassword()%>" name="password" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPasswordRepait" class="col-sm-4 col-form-label" >Repita contraseña:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="password_repitida" value="<%= usuarioUpdateDTO.getPassword()%>" id="inputPasswordRepait" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-8 offset-sm-4">
                        <button type="submit" class="btn btn-custom-teal text-white">Actualizar</button>
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


