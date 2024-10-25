package com.edutecno.final_drilling.servlets;

import com.edutecno.final_drilling.modelo.Usuario;
import com.edutecno.final_drilling.service.UserService;
import com.edutecno.final_drilling.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Optional<Usuario> usuarioOptional = userService.login(username, password);
        if (usuarioOptional.isPresent()) {
            System.out.println("Esta presente");
            HttpSession session = request.getSession();
            session.setAttribute("username", usuarioOptional.get().getUsername());
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");

            // Redirige a la página de login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}