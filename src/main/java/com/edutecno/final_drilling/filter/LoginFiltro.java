package com.edutecno.final_drilling.filter;

import com.edutecno.final_drilling.service.SessionAuthenticationService;
import com.edutecno.final_drilling.service.SessionAuthenticationServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/home", "/consultaHoroscopo", "/modificarUsuario", "/buscarUsuario", "/eliminarCuenta"})
public class LoginFiltro implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SessionAuthenticationService service = new SessionAuthenticationServiceImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else{
            ((HttpServletResponse)response).sendRedirect( ((HttpServletRequest) request).getContextPath() +"/unauthorized");
        }
    }
}
