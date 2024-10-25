package com.edutecno.final_drilling.modelo;

import java.util.Date;

public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private String password;
    private int horoscopoId;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String username, String email, Date fechaNacimiento, String password, int horoscopoId) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.horoscopoId = horoscopoId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHoroscopoId() {
        return horoscopoId;
    }

    public void setHoroscopoId(int horoscopoId) {
        this.horoscopoId = horoscopoId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
