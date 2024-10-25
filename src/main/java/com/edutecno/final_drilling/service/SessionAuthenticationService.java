package com.edutecno.final_drilling.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface SessionAuthenticationService {
    /**
     * Obtiene el nombre de usuario almacenado en la sesión actual.
     * Este método busca el atributo de sesión "username" en el objeto HttpServletRequest.
     * Si el nombre de usuario está presente en la sesión, se devuelve como un Optional no vacío.
     * Si no está presente, se devuelve un Optional vacío.
     *
     * @param request El objeto HttpServletRequest que contiene la sesión activa del usuario.
     * @return Un Optional que contiene el nombre de usuario si está presente, o un Optional vacío si no lo está.
     */
    Optional<String> getUsername(HttpServletRequest request);
}
