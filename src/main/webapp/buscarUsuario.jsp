
<%@ page import="java.util.List" %>
<%@ page import="com.edutecno.final_drilling.dto.UsuarioResponseDto" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="./asset/css/style.css">
</head>
<%--<header class="bg-custom-teal text-white py-3">--%>
<%--    <div class="container d-flex align-items-center justify-content-between">--%>
<%--        <div>--%>
<%--            <a href="${pageContext.request.contextPath}/home" class="text-white text-decoration-none">--%>
<%--                <h5 class="mb-0 me-3">Horóscopo Chino</h5>--%>
<%--            </a>--%>
<%--            <small class="text-light">Tu Horóscopo Chino</small>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <!-- Enlace de logout -->--%>
<%--            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Logout</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>
<%@include file="headerLogin.jsp"%>

<body>
<main class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>
<div class="row">
    <!-- Formulario único para buscar departamentos -->
    <div class="col-md-12">
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">Buscar Usuarios</h5>
                <form action="${pageContext.request.contextPath}/buscarUsuario" method="GET" id="buscarDepartamentoForm"> <!-- Ajusta la acción a tu servlet -->
                    <div class="row">
                        <!-- Buscar por Nombre -->
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="nombre">NOMBRE USUARIO</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del Usuario">
                            </div>
                        </div>

                        <!-- Buscar por Número -->
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="username">USERNAME</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="username">
                            </div>
                        </div>

                        <!-- Buscar por Ubicación -->
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="signo">SIGNO</label>
                                <input type="text" class="form-control" id="signo" name="signo" placeholder="Signo">
                            </div>
                        </div>
                    </div>

                    <!-- Botones de Buscar y Limpiar -->
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-primary">Buscar</button>
                        </div>
                        <div class="col-md-6 text-right">
                            <button type="reset" class="btn btn-secondary">Limpiar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="table-responsive">
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Signo</th>
            <th>Email</th>
            <th>Fecha de Nacimiento</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Suponiendo que tienes una lista de usuarios pasada desde el Servlet
            List<UsuarioResponseDto> listaUsuarios = (List<UsuarioResponseDto>) request.getAttribute("usuarioResponseDtos");

            if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
                for (UsuarioResponseDto usuario : listaUsuarios) {
        %>
        <tr id="<%=usuario.id()%>">
            <td><%= usuario.nombre() %></td>
            <td><%= usuario.username() %></td>
            <td><%= usuario.horoscopoAnimal() %></td>
            <td><%= usuario.email() %></td>
            <td><%= usuario.fechaNacimiento() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="2" class="text-center">No hay departamentos disponibles</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</div>
</main>
</body>
