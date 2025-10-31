/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author arceb
 */
public class TicketCompra {
    
    private int idTicket;
    private LocalDate fechaCompra;
    private LocalDateTime fechaFuncion;
    private double monto;
    private Comprador comprador;
    private DetalleTicket detalleticket;

    public TicketCompra() {
    }

    public TicketCompra(LocalDate fechaCompra, LocalDateTime fechaFuncion, double monto, Comprador comprador, DetalleTicket detalleticket) {
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
        this.comprador = comprador;
        this.detalleticket = detalleticket;
    }

    public TicketCompra(int idTicket, LocalDate fechaCompra, LocalDateTime fechaFuncion, double monto, Comprador comprador, DetalleTicket detalleticket) {
        this.idTicket = idTicket;
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
        this.comprador = comprador;
        this.detalleticket = detalleticket;
    }

    public DetalleTicket getDetalleticket() {
        return detalleticket;
    }

    public void setDetalleticket(DetalleTicket detalleticket) {
        this.detalleticket = detalleticket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDateTime getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(LocalDateTime fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "TicketCompra{" + "fechaCompra=" + fechaCompra + ", fechaFuncion=" + fechaFuncion + ", monto=" + monto + ", comprador=" + comprador + '}';
    }
    
    
    
}
