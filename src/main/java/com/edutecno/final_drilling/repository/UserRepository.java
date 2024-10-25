package com.edutecno.final_drilling.repository;

import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<Usuario> findAllUsers();
    Optional<Usuario> findUserById(int id);
    Usuario findUserByUsername(String username);
    void saveUser(Usuario usuario);
    void deleteUser(int usuario_id);
    void updateUser(Usuario usuario);
    UsuarioResponseDto getUserHoroscopoByUsername(String username);
    List<UsuarioResponseDto> searchUser(String nombre, String username, String signo);
}
