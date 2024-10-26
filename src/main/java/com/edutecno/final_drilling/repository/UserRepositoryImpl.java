package com.edutecno.final_drilling.repository;

import com.edutecno.final_drilling.configuration.DatabaseConnection;
import com.edutecno.final_drilling.dto.UsuarioResponseDto;
import com.edutecno.final_drilling.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<Usuario> findAllUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "select * from usuarios";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setEmail(rs.getString("email"));
                usuario.setHoroscopoId(rs.getInt("horoscopoId"));
                usuarios.add(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> findUserById(int id) {
        String query = "select * from usuarios where id = ?";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)
        ){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setHoroscopoId(rs.getInt("horoscopo_id"));
                    return Optional.of(usuario);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateUser(Usuario usuario) {
        String query = "update usuarios SET nombre = ?, username = ?, email = ?, fecha_nacimiento = ?, password = ?, horoscopo_id = ? WHERE id = ? ";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)
        ){
            setUserPreparedStatement (usuario, ps);
            ps.setInt(7, usuario.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void setUserPreparedStatement (Usuario usuario, PreparedStatement ps) throws SQLException {
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getUsername());
        ps.setString(3, usuario.getEmail());
        ps.setDate(4, new Date(usuario.getFechaNacimiento().getTime()));
        ps.setString(5, usuario.getPassword());
        ps.setInt(6, usuario.getHoroscopoId());
    }

    @Override
    public UsuarioResponseDto getUserHoroscopoByUsername(String username) {
        UsuarioResponseDto usuarioResponseDto = null;
        String query = "SELECT usuarios.id, nombre, username, email, fecha_nacimiento, animal from usuarios inner join horoscopo on usuarios.horoscopo_id = horoscopo.id where usuarios.username = ? ";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)
        ){
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    usuarioResponseDto = getUsuarioResponseDto(rs);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarioResponseDto;
    }

    @Override
    public Usuario findUserByUsername(String username) {
        Usuario usuario = null;
        String query = "select * from usuarios where username = ?";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)
        ){
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setHoroscopoId(rs.getInt("horoscopo_id"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void saveUser(Usuario usuario) {
        String query = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, horoscopo_id) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ){
            setUserPreparedStatement(usuario, ps);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<UsuarioResponseDto> searchUser(String nombre, String username, String signo) {
        List<UsuarioResponseDto> usuarios = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT usuarios.id, nombre, username, email, fecha_nacimiento, animal from usuarios inner join horoscopo on usuarios.horoscopo_id = horoscopo.id where 1=1");
        if(nombre != null && !nombre.isEmpty()) {
            query.append(" AND nombre LIKE '%"+nombre+"%'");
        }
        if(username != null && !username.isEmpty()) {
            query.append(" AND username LIKE '%"+username+"%'");
        }
        if(signo != null && !signo.isEmpty()) {
            query.append(" AND animal LIKE '%"+signo+"%'");
        }

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery()
        ){
            UsuarioResponseDto usuario = null;
            while(rs.next()) {
                usuario = getUsuarioResponseDto(rs);
                usuarios.add(usuario);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    private UsuarioResponseDto getUsuarioResponseDto(ResultSet rs) throws SQLException {
        UsuarioResponseDto usuario;
        int id = rs.getInt("id");
        String get_nombre = rs.getString("nombre");
        String get_username = rs.getString("username");
        String email = rs.getString("email");
        java.util.Date fechaNacimiento = rs.getDate("fecha_nacimiento");
        String animal = rs.getString("animal");
        usuario = new UsuarioResponseDto(id, get_nombre, get_username, email, fechaNacimiento, animal);
        return usuario;
    }

    @Override
    public void deleteUser(int usuario_id) {
        String query = "delete from usuarios where id = ?";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, usuario_id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
