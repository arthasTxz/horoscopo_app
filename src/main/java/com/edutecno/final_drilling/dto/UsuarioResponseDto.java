package com.edutecno.final_drilling.dto;

import java.util.Date;

public record UsuarioResponseDto(
        int id,
        String nombre,
        String username,
        String email,
        Date fechaNacimiento,
        String horoscopoAnimal
) {
}
