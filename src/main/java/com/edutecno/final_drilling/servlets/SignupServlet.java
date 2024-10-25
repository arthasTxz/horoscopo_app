package com.edutecno.final_drilling.servlets;

import com.edutecno.final_drilling.dto.UsuarioCreateDto;
import com.edutecno.final_drilling.service.UserService;
import com.edutecno.final_drilling.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "Signup", value = "/registro")
public class SignupServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("signup.jsp");
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_repitida = request.getParameter("password_repitida");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");

        if(!password.equals(password_repitida)) {
            request.setAttribute("error", "Passwords do not match");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("name", nombre);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimientoDate = null;
            try{
                fechaNacimientoDate = formatter.parse(fechaNacimiento);
            }catch(ParseException e){
                e.printStackTrace();
            }

            System.out.println(nombre + " " + username + " " + password + " " + email + " " + fechaNacimientoDate);
            UsuarioCreateDto usuarioCreateDto = new UsuarioCreateDto(nombre, username, email, fechaNacimientoDate, password);
            userService.saveUser(usuarioCreateDto);
            response.sendRedirect("login");
        }

    }
}