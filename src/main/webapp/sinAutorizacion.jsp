<%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 25-10-2024
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Unauthorized</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      <link rel="stylesheet" href="./asset/css/style.css">
  </head>
  <body>
  <%@include file="header.jsp"%>
  <div class="container">
    <h1 class="text-center">Mi Imagen</h1>

    <!-- Contenedor para centrar la imagen -->
    <div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
      <img src="${pageContext.request.contextPath}/asset/illegal-its-illegal.jpg" alt="Descripción de la imagen">
    </div>
  </div>
  </body>
</html>
