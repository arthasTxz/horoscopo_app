package com.edutecno.final_drilling.servlets;

import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.dto.UsuarioUpdateDTO;
import com.edutecno.final_drilling.modelo.Usuario;
import com.edutecno.final_drilling.service.SessionAuthenticationService;
import com.edutecno.final_drilling.service.SessionAuthenticationServiceImpl;
import com.edutecno.final_drilling.service.UserService;
import com.edutecno.final_drilling.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@WebServlet(name = "ModificarUsuarioServlet", value = "/modificarUsuario")
public class ModificarUsuarioServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Optional<UsuarioUpdateDTO> usuarioUpdateOptional = userService.buscarUsuarioPorUsername(username);
        if (usuarioUpdateOptional.isPresent()) {
            UsuarioUpdateDTO usuarioUpdateDTO = usuarioUpdateOptional.get();
            request.setAttribute("usuario", usuarioUpdateDTO);
            request.getRequestDispatcher("/actualizarUsuario.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repitida = request.getParameter("password_repitida");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String email = request.getParameter("email");

        if(!password.equals(password_repitida)) {
            Optional<UsuarioUpdateDTO> usuarioOriginal = userService.buscarUsuarioPorUsername(username);
            if (usuarioOriginal.isPresent()) {
                request.setAttribute("usuario", usuarioOriginal.get());
                request.setAttribute("error", "Passwords do not match");
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
            }

        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoDate = null;
        try{
            fechaNacimientoDate = formatter.parse(fechaNacimiento);
        }catch(ParseException e){
            e.printStackTrace();
        }
        UsuarioUpdateDTO usuarioUpdate = new UsuarioUpdateDTO(nombre, username, password, email, fechaNacimientoDate);
        SessionAuthenticationService sessionAuthenticationService = new SessionAuthenticationServiceImpl();
        Optional<String> auth = sessionAuthenticationService.getUsername(request);
        if (auth.isPresent()) {
            Optional<UsuarioResponseDto> usuarioOriginal = userService.getUserWithHoroscopo(auth.get());
            if (usuarioOriginal.isPresent()) {
//                System.out.println("Esta entrando al post: " + usuarioOriginal.get());
                usuarioUpdate.setId(usuarioOriginal.get().id());
                boolean updated = userService.updateUser(usuarioUpdate);
                if(updated){
                    HttpSession session = request.getSession();
                    session.setAttribute("username", usuarioUpdate.getUsername());
                    request.setAttribute("successMessage", "Datos modificados correctamente");
                    request.getRequestDispatcher("/home").forward(request, response);
                }

            }
        }

    }
}