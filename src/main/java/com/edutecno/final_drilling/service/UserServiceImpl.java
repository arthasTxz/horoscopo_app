package com.edutecno.final_drilling.service;

import com.edutecno.final_drilling.dto.UsuarioCreateDto;
import com.edutecno.final_drilling.dto.UsuarioMapper;
import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.dto.UsuarioUpdateDTO;
import com.edutecno.final_drilling.modelo.Horoscopo;
import com.edutecno.final_drilling.modelo.Usuario;
import com.edutecno.final_drilling.repository.HoroscopoRepository;
import com.edutecno.final_drilling.repository.HoroscopoRepositoryImpl;
import com.edutecno.final_drilling.repository.UserRepository;
import com.edutecno.final_drilling.repository.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private HoroscopoRepository horoscopoRepository;

    public UserServiceImpl(){
        this.userRepository = new UserRepositoryImpl();
        this.horoscopoRepository = new HoroscopoRepositoryImpl();
    }

    @Override
    public List<UsuarioResponseDto> listarUsuarios() {
        return List.of();
    }

    @Override
    public Optional<UsuarioUpdateDTO> buscarUsuarioPorUsername(String username) {
        try{
            Usuario usuario = userRepository.findUserByUsername(username);
            UsuarioUpdateDTO usuarioUpdateDTO = new UsuarioUpdateDTO(usuario.getNombre(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), usuario.getFechaNacimiento());
            return Optional.of(usuarioUpdateDTO);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public void saveUser(UsuarioCreateDto usuario) {
        List<Horoscopo> horoscopos = horoscopoRepository.findAll();
        Horoscopo horoscopo = null;
        Usuario usuario1 = new Usuario();
        for (Horoscopo temp : horoscopos) {
            if(usuario.fechaNacimiento().after(temp.getFechaInicio()) && usuario.fechaNacimiento().before(temp.getFechaFin())){
                horoscopo = temp;
            } else if (usuario.fechaNacimiento().equals(temp.getFechaFin()) || usuario.fechaNacimiento().equals(temp.getFechaInicio())) {
                horoscopo = temp;
            }
        }
        if(horoscopo != null){
            usuario1.setNombre(usuario.nombre());
            usuario1.setUsername(usuario.username());
            usuario1.setEmail(usuario.email());
            usuario1.setPassword(usuario.password());
            usuario1.setFechaNacimiento(usuario.fechaNacimiento());
            usuario1.setHoroscopoId(horoscopo.getId());
            userRepository.saveUser(usuario1);
        }

    }

    @Override
    public boolean deleteUser(UsuarioResponseDto usuario) {
        Optional<Usuario> usuarioOptional = userRepository.findUserById(usuario.id());
        if(usuarioOptional.isPresent()){
            userRepository.deleteUser(usuario.id());
            return true;
        }
        return false;
    }

    /** Metodo encargado de la autenticacion del usuario
     * @param username
     * @param password
     * @return
     */
    @Override
    public Optional<Usuario> login(String username, String password) {
        try{
//            Usuario usuario = userRepository.findUserByUsername(username);
//            System.out.println(usuario.getPassword());
            return Optional.ofNullable(userRepository.findUserByUsername(username))
                    .filter(user -> user.getPassword().equals(password));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    /**
     * El metodo devuelve un Objeto del tipo UserResponseDto el cual incluye el Animal del
     * horoscopo que le corresponde
     * @param username
     * @return devuelve un usuario con el nombre, username, email, fecha de nacimiento y horoscopoco
     */
    @Override
    public Optional<UsuarioResponseDto> getUserWithHoroscopo(String username) {
        try{
            UsuarioResponseDto usuarioResponseDto = userRepository.getUserHoroscopoByUsername(username);
            return Optional.ofNullable(usuarioResponseDto);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<UsuarioResponseDto> searchUser(String name, String username, String signo) {
        List<UsuarioResponseDto> listaUsuarios = userRepository.searchUser(name, username, signo);
        return listaUsuarios;
    }

    /**
     *
     * @param usuarioUpdateDTO
     */

    @Override
    public boolean updateUser(UsuarioUpdateDTO usuarioUpdateDTO) {
        List<Horoscopo> horoscopos = horoscopoRepository.findAll();
        Horoscopo horoscopo = null;
        Usuario usuario;
        for (Horoscopo temp : horoscopos) {
            if(usuarioUpdateDTO.getFechaNacimiento().after(temp.getFechaInicio()) && usuarioUpdateDTO.getFechaNacimiento().before(temp.getFechaFin())){
                horoscopo = temp;
            } else if (usuarioUpdateDTO.getFechaNacimiento().equals(temp.getFechaFin()) || usuarioUpdateDTO.getFechaNacimiento().equals(temp.getFechaInicio())) {
                horoscopo = temp;
            }
        }
        if(horoscopo != null){
            usuario = UsuarioMapper.mapFromDto(usuarioUpdateDTO);
            usuario.setHoroscopoId(horoscopo.getId());
            System.out.println(usuario);
            userRepository.updateUser(usuario);
            return true;
        }
        return false;

    }
}
