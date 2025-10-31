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
public class Lugar {
    
    private int idLugar;
    private char fila;
    private int num;
    private boolean estado;
    private Funcion funcion;

    public Lugar() {
    }

    public Lugar(char fila, int num, boolean estado, Funcion funcion) {
        this.fila = fila;
        this.num = num;
        this.estado = estado;
        this.funcion = funcion;
    }

    public Lugar(int idLugar, char fila, int num, boolean estado, Funcion funcion) {
        this.idLugar = idLugar;
        this.fila = fila;
        this.num = num;
        this.estado = estado;
        this.funcion = funcion;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Lugar{" + "fila=" + fila + ", num=" + num + ", estado=" + estado + ", funcion=" + funcion + '}';
    }
    
    
    
    
    
}
