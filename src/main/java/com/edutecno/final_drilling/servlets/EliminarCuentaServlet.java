package com.edutecno.final_drilling.servlets;

import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.service.SessionAuthenticationService;
import com.edutecno.final_drilling.service.SessionAuthenticationServiceImpl;
import com.edutecno.final_drilling.service.UserService;
import com.edutecno.final_drilling.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "EliminarCuentaServlet", value = "/eliminarCuenta")
public class EliminarCuentaServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/eliminarCuenta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionAuthenticationService auth = new SessionAuthenticationServiceImpl();
        Optional<String> username = auth.getUsername(request);
        if (username.isPresent()) {
            Optional< UsuarioResponseDto> usuarioResponseDto =  userService.getUserWithHoroscopo(username.get());
            usuarioResponseDto.ifPresent(responseDto -> userService.deleteUser(responseDto));
            HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("successMessage", "Datos eliminados correctamente");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}