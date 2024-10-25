package com.edutecno.final_drilling.service;

import com.edutecno.final_drilling.dto.UsuarioCreateDto;
import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.dto.UsuarioUpdateDTO;
import com.edutecno.final_drilling.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UsuarioResponseDto> listarUsuarios();
    Optional<UsuarioUpdateDTO> buscarUsuarioPorUsername(String username);
    void saveUser(UsuarioCreateDto usuario);
    boolean deleteUser(UsuarioResponseDto usuario);
    boolean updateUser(UsuarioUpdateDTO usuario);
    Optional<Usuario> login(String username, String password);
    Optional<UsuarioResponseDto> getUserWithHoroscopo(String username);
    List<UsuarioResponseDto> searchUser(String name, String username, String signo);
}
