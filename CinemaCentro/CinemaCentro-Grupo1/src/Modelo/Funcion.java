/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arceb
 */
public class Funcion {
    
    private int idFuncion;
    private Pelicula pelicula;
    private String idioma;
    private boolean es3d;
    private boolean subtitulado;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private List<Lugar> listaLugaresDisp;
    private Sala salaProyeccion;
    private double precio;

    public Funcion() {
    }

    public Funcion(Pelicula pelicula, String idioma, boolean es3d, boolean subtitulado, LocalDateTime horaInicio, LocalDateTime horaFin, List<Lugar> listaLugaresDisp, Sala salaProyeccion, double precio) {
        this.pelicula = pelicula;
        this.idioma = idioma;
        this.es3d = es3d;
        this.subtitulado = subtitulado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaLugaresDisp = listaLugaresDisp = new ArrayList<>();
        this.salaProyeccion = salaProyeccion;
        this.precio = precio;
    }

    public Funcion(int idFuncion, Pelicula pelicula, String idioma, boolean es3d, boolean subtitulado, LocalDateTime horaInicio, LocalDateTime horaFin, List<Lugar> listaLugaresDisp, Sala salaProyeccion, double precio) {
        this.idFuncion = idFuncion;
        this.pelicula = pelicula;
        this.idioma = idioma;
        this.es3d = es3d;
        this.subtitulado = subtitulado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaLugaresDisp = listaLugaresDisp;
        this.salaProyeccion = salaProyeccion;
        this.precio = precio;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEs3d() {
        return es3d;
    }

    public void setEs3d(boolean es3d) {
        this.es3d = es3d;
    }

    public boolean isSubtitulado() {
        return subtitulado;
    }

    public void setSubtitulado(boolean subtitulado) {
        this.subtitulado = subtitulado;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public List<Lugar> getListaLugaresDisp() {
        return listaLugaresDisp;
    }

    public void setListaLugaresDisp(List<Lugar> listaLugaresDisp) {
        this.listaLugaresDisp = listaLugaresDisp;
    }

    public Sala getSalaProyeccion() {
        return salaProyeccion;
    }

    public void setSalaProyeccion(Sala salaProyeccion) {
        this.salaProyeccion = salaProyeccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Funcion{" + "pelicula=" + pelicula + ", idioma=" + idioma + ", es3d=" + es3d + ", subtitulado=" + subtitulado + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", listaLugaresDisp=" + listaLugaresDisp + ", salaProyeccion=" + salaProyeccion + ", precio=" + precio + '}';
    }

    
    
    
    
    
    
    
    
    
}
