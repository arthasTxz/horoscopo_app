package com.edutecno.final_drilling.dto;

import java.util.Date;

public class UsuarioUpdateDTO{
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String email;
    private Date fechaNacimiento;

    public UsuarioUpdateDTO() {
    }

    public UsuarioUpdateDTO( String nombre, String username, String password, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
