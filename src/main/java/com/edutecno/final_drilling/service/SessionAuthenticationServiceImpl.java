package com.edutecno.final_drilling.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class SessionAuthenticationServiceImpl implements SessionAuthenticationService{

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        System.out.println("Login auth = " + username);
        if(username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
