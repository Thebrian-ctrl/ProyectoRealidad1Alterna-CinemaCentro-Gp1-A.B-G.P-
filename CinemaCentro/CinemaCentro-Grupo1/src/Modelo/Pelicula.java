/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author arceb
 */
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String director, actores, origen, genero;
    private LocalDate estreno;
    private boolean cartelera;
    private String rutaImagen;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, String actores, String origen, String genero, LocalDate estreno, boolean cartelera, String rutaImagen) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.cartelera = cartelera;
        this.rutaImagen = rutaImagen;
    }

    public Pelicula(int idPelicula, String titulo, String director, String actores, String origen, String genero, LocalDate estreno, boolean cartelera, String rutaImagen) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.cartelera = cartelera;
        this.rutaImagen = rutaImagen;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public boolean isCartelera() {
        return cartelera;
    }

    public void setCartelera(boolean cartelera) {
        this.cartelera = cartelera;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
       // return "Pelicula{" + "idPelicula=" + idPelicula + ", titulo=" + titulo + ", director=" + director + ", actores=" + actores + ", origen=" + origen + ", genero=" + genero + ", estreno=" + estreno + ", cartelera=" + cartelera + ", rutaImagen=" + rutaImagen + '}';
        return titulo + " (" + genero + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idPelicula;
        hash = 53 * hash + Objects.hashCode(this.titulo);
        hash = 53 * hash + Objects.hashCode(this.director);
        hash = 53 * hash + Objects.hashCode(this.actores);
        hash = 53 * hash + Objects.hashCode(this.origen);
        hash = 53 * hash + Objects.hashCode(this.genero);
        hash = 53 * hash + Objects.hashCode(this.estreno);
        hash = 53 * hash + (this.cartelera ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.rutaImagen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.idPelicula != other.idPelicula) {
            return false;
        }
        if (this.cartelera != other.cartelera) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.actores, other.actores)) {
            return false;
        }
        if (!Objects.equals(this.origen, other.origen)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.rutaImagen, other.rutaImagen)) {
            return false;
        }
        if (!Objects.equals(this.estreno, other.estreno)) {
            return false;
        }
        return true;
    }

    

   
    
    
    
    
    
    
}
