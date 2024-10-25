<%--
  Created by IntelliJ IDEA.
  User: yabeto
  Date: 24-10-2024
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<header class="bg-custom-teal text-white py-3">
    <div class="container d-flex align-items-center justify-content-between">
        <div>
            <a href="${pageContext.request.contextPath}/home" class="text-white text-decoration-none">
                <h5 class="mb-0 me-3">Horóscopo Chino, <%= (String)session.getAttribute("username")%></h5>
            </a>
            <small class="text-light">Tu Horóscopo Chino</small>
        </div>
        <div>
            <!-- Enlace de logout -->
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Logout</a>
        </div>
    </div>
</header>
