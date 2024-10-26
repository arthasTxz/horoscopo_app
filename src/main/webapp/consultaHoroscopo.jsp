<%@ page import="com.edutecno.final_drilling.dto.UsuarioResponseDto" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consulta Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="./asset/css/style.css">
</head>
<body>
<%@include file="headerLogin.jsp"%>

<div class="main-content container">
    <!-- Mostrar el nombre de usuario desde la sesión -->

    <h1>Conoce a tu animal del horoscopo chino</h1>
    <% UsuarioResponseDto usuario = (UsuarioResponseDto) request.getAttribute("username"); %>
    <h1>Tu animal es <%= usuario.horoscopoAnimal() %></h1>

</div>
</body>
</html>