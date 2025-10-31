/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author arceb
 */
public class Sala {
    private int idSala;
    private int nroSala;
    private boolean apto3d;
    private int capacidad;
    private boolean estado;

    public Sala() {
    }

    public Sala(int nroSala, boolean apto3d, int capacidad, boolean estado) {
        this.nroSala = nroSala;
        this.apto3d = apto3d;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Sala(int idSala, int nroSala, boolean apto3d, int capacidad, boolean estado) {
        this.idSala = idSala;
        this.nroSala = nroSala;
        this.apto3d = apto3d;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public boolean isApto3d() {
        return apto3d;
    }

    public void setApto3d(boolean apto3d) {
        this.apto3d = apto3d;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sala{" + "idSala=" + idSala + ", nroSala=" + nroSala + ", apto3d=" + apto3d + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
}
