/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author arceb
 */
public class DetalleTicket {
    
    private int idDetalleTicket;
    private Funcion funcion;
    private Lugar lugar;
    private int cantidad;
    private double subtotal;

    public DetalleTicket() {
    }

    public DetalleTicket(Funcion funcion, Lugar lugar, int cantidad, double subtotal) {
        this.funcion = funcion;
        this.lugar = lugar;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleTicket(int idDetalleTicket, Funcion funcion, Lugar lugar, int cantidad, double subtotal) {
        this.idDetalleTicket = idDetalleTicket;
        this.funcion = funcion;
        this.lugar = lugar;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalleTicket() {
        return idDetalleTicket;
    }

    public void setIdDetalleTicket(int idDetalleTicket) {
        this.idDetalleTicket = idDetalleTicket;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + "idDetalleTicket=" + idDetalleTicket + ", funcion=" + funcion + ", lugar=" + lugar + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
    
    
    
    
    
    
    
}
