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

@WebServlet(name = "ConsultarHoroscopoServlet", value = "/consultaHoroscopo")
public class ConsultarHoroscopoServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionAuthenticationService loginService = new SessionAuthenticationServiceImpl();
        Optional<String> username = loginService.getUsername(request);
        if (username.isPresent()) {
            Optional<UsuarioResponseDto> usuarioResponseDto = userService.getUserWithHoroscopo(username.get());
            if (usuarioResponseDto.isPresent()) {
//                System.out.println(usuarioResponseDto.get().horoscopoAnimal());
                request.setAttribute("username", usuarioResponseDto.get());
                request.getRequestDispatcher("/consultaHoroscopo.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}