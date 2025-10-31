/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author arceb
 */
public class Comprador {
    
    private int idComprador;
    private int dni;
    private String nombre, password, medioDePago;
    private LocalDate fechaNac;

    public Comprador() {
    }

    public Comprador(int dni, String nombre, String password, String medioDePago, LocalDate fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.password = password;
        this.medioDePago = medioDePago;
        this.fechaNac = fechaNac;
    }

    public Comprador(int idComprador, int dni, String nombre, String password, String medioDePago, LocalDate fechaNac) {
        this.idComprador = idComprador;
        this.dni = dni;
        this.nombre = nombre;
        this.password = password;
        this.medioDePago = medioDePago;
        this.fechaNac = fechaNac;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Comprador{" + "dni=" + dni + ", nombre=" + nombre + ", password=" + password + ", medioDePago=" + medioDePago + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
    
}
