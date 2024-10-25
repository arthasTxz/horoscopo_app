package com.edutecno.final_drilling.servlets;

import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.service.UserService;
import com.edutecno.final_drilling.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BuscarUsuarioServlet", value = "/buscarUsuario")
public class BuscarUsuarioServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String username = request.getParameter("username");
        String signo = request.getParameter("signo");

        List<UsuarioResponseDto> usuarioResponseDtos = userService.searchUser(nombre, username, signo);
        request.setAttribute("usuarioResponseDtos", usuarioResponseDtos);
        request.getRequestDispatcher("buscarUsuario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}