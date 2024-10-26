package com.edutecno.final_drilling.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UnauthorizedServlet", value = "/unauthorized")
public class UnauthorizedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/sinAutorizacion.jsp").forward(request, response);
        /*response.sendRedirect(request.getContextPath() + "/sinAutorizacion.jsp");*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}