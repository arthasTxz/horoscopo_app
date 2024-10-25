<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Confirmación de eliminación</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    .bg-custom-teal { background-color: #009688; }
    .btn-custom-teal { background-color: #009688; border-color: #009688; }
    .btn-custom-teal:hover { background-color: #00796b; border-color: #00796b; }
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f5f5f5;
      margin: 0;
    }
    header {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      background-color: #343a40;
      color: white;
      padding: 10px 0;
      text-align: center;
      z-index: 1000;
    }
    .confirm-box {
      background-color: white;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    }
    .main-content {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
      padding-top: 100px; /* Para que el contenido no se solape con el header */
    }

    h1 {
      margin-bottom: 30px;
    }
    .btn-group {
      display: flex;
      flex-direction: row;
      gap: 15px; /* Separación entre los botones */
    }
  </style>
</head>
<body>
<%@include file="headerLogin.jsp"%>
<div class="confirm-box">
  <h3>¿Estás seguro de que deseas eliminar tu cuenta?</h3>
  <p>Esta acción no se puede deshacer.</p>

  <div class="btn-group">
    <!-- Formulario con método POST para eliminar la cuenta -->
    <form action="/eliminarCuenta" method="POST">
      <button type="submit" class="btn btn-danger">Sí, eliminar cuenta</button>
    </form>

    <!-- Enlace para regresar a la página principal -->
    <a href="/home" class="btn btn-secondary">No, regresar a la página principal</a>
  </div>
</div>
</body>
</html>
