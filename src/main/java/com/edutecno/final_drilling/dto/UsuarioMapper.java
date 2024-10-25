package com.edutecno.final_drilling.dto;

import com.edutecno.final_drilling.modelo.Usuario;

public class UsuarioMapper {

    public static Usuario mapFromDto(UsuarioUpdateDTO dto) {
        Usuario usuario = new Usuario();

        // Asumiendo que tienes setters en tu clase Usuario, asigna los valores
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        // Agrega aquí el mapeo de los campos que desees

        return usuario;
    }
}
