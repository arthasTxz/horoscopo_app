<%@ page import="com.edutecno.final_drilling.dto.UsuarioResponseDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edutecno.final_drilling.service.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 21-10-2024
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table table-striped">
    <thead class="table-dark">
    <tr>
        <th>Nro</th>
        <th>Nombre</th>
        <th>Ubicacion</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Suponiendo que tienes una lista de clientes pasada desde el Servlet
        List<UsuarioResponseDto> usersList = new UserServiceImpl().listarUsuarios();
        System.out.println(usersList);

        if (usersList != null && !usersList.isEmpty()) {
            for (UsuarioResponseDto user : usersList) {
    %>
    <tr id="<%=user.id()%>">
        <td><%= user.nombre() %></td>
        <td><%= user.username() %></td>
        <td><%= user.horoscopoAnimal() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2" class="text-center">No hay horoscopos disponibles</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
