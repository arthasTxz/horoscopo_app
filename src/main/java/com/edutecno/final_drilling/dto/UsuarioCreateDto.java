package com.edutecno.final_drilling.dto;

import java.util.Date;

public record UsuarioCreateDto(
        String nombre,
        String username,
        String email,
        Date fechaNacimiento,
        String password
) {
}
