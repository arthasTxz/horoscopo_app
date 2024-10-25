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
<%--<header class="bg-custom-teal text-white py-3">--%>
<%--    <div class="container d-flex align-items-center justify-content-between">--%>
<%--        <div>--%>
<%--            <h5 class="mb-0 me-3">Horóscopo Chino</h5>--%>
<%--            <small class="text-light">Tu Horóscopo Chino</small>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <!-- Enlace de logout -->--%>
<%--            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Logout</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>
<%@include file="headerLogin.jsp"%>

<div class="main-content container">
    <!-- Mostrar el nombre de usuario desde la sesión -->

    <h1>Conoce a tu animal del horoscopo chino</h1>
    <% UsuarioResponseDto usuario = (UsuarioResponseDto) request.getAttribute("username"); %>
    <% System.out.println("Desde jsp: " + usuario.username());%>
    <h1>Tu animal es <%= usuario.horoscopoAnimal() %></h1>
    <!-- Grupo de botones centrados -->
<%--    <div class="btn-group" role="group">--%>
<%--        <a href="/consultaHoroscopo" class="btn btn-custom-teal text-white" >Conoce tu animal</a>--%>
<%--        <a href="buscarUsuarios.jsp" class="btn btn-custom-teal text-white" >Buscar usuarios</a>--%>
<%--        <a href="modificarDatos.jsp" class="btn btn-custom-teal text-white" >Modificar datos</a>--%>
<%--        <a href="modificarDatos.jsp" class="btn btn-custom-teal text-white" >Eliminar cuenta</a>--%>
<%--    </div>--%>
</div>
</body>
</html>