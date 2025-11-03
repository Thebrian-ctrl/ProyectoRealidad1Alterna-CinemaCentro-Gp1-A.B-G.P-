/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.MyConexion;
import Modelo.Pelicula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arceb
 */
public class PeliculaData {
    
    private final Connection conn;
    
    public PeliculaData (){
        conn = MyConexion.buscarConexion();
    
    }
    
    public void guardarPelicula(Pelicula p){
        String query = "INSERT INTO pelicula(titulo, director, actores, origen, genero, estreno, cartelera, rutaImagen)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(3, p.getActores());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, Date.valueOf(p.getEstreno()));
            ps.setBoolean(7, p.isCartelera());
            ps.setString(8, p.getRutaImagen());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()) {
                p.setIdPelicula(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pelicula guardada correctamente");
            
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar la pelicula");
            }
            ps.close();
            System.out.println("Guardado");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + e.getMessage());
        }
    
    }      
    
    public Pelicula buscarPelicula (String titulo){
    
        String query = "SELECT * FROM pelicula WHERE titulo = ?";
        
        Pelicula peli = null;
        
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, titulo);
        
        ResultSet rs = ps.executeQuery();
        
        
            if(rs.next()){
              peli = new Pelicula();
              peli.setIdPelicula(rs.getInt("idPelicula"));
              peli.setTitulo(rs.getString("titulo"));
              peli.setDirector(rs.getString("director"));
              peli.setActores(rs.getString("actores"));
              peli.setOrigen(rs.getString("origen"));
              peli.setGenero(rs.getString("genero"));
              peli.setEstreno(rs.getDate("estreno").toLocalDate());
              peli.setCartelera(rs.getBoolean("cartelera"));
              peli.setRutaImagen(rs.getString("rutaImagen"));
        
        
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la pelicula " + titulo + " en la base de datos");
            }
            ps.close();
    
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula solicitada: " + e.getMessage());
        
        }
        
        return peli;
    }
    
    public List<Pelicula> listarPeliculasCartelera(){
        String query = "SELECT * FROM pelicula WHERE cartelera = true";
        
        List<Pelicula> peliculas = new ArrayList<>();
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Pelicula peli = new Pelicula();
                    
                    peli.setIdPelicula(rs.getInt("idPelicula"));
                    peli.setTitulo(rs.getString("titulo"));
                    peli.setDirector(rs.getString("director"));
                    peli.setActores(rs.getString("actores"));
                    peli.setOrigen(rs.getString("origen"));
                    peli.setGenero(rs.getString("genero"));
                    peli.setEstreno(rs.getDate("estreno").toLocalDate());
                    peli.setCartelera(rs.getBoolean("cartelera"));
                    peli.setRutaImagen(rs.getString("rutaImagen"));
                    
                    peliculas.add(peli);
                
                
                }
                
                ps.close();
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar las peliculas en cartelera: " + e.getMessage());
            
        }
            return peliculas;
    }
    
    public void darBajaCartelera(int idPelicula){
        String query = "UPDATE pelicula SET cartelera = false WHERE idPelicula = ?";
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idPelicula);
                
                int actualizado = ps.executeUpdate();
                
                if(actualizado == 1){
                    JOptionPane.showMessageDialog(null, "Pelicula dada de baja correctamente");                           
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro pelicula con el id especificado");                    
                }
                ps.close();                                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja a la pelicula: " + e.getMessage());
        }   
    }
    
    
    public void darAltaCartelera(int idPelicula){
        String query = "UPDATE pelicula SET cartelera = true WHERE idPelicula = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
             
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Pelicula dada de alta correctamente");           
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro pelicula con el id especificado");
            }
                ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta a la pelicula: " + e.getMessage());
            
        }
    
    
    }
    
    public void eliminarPelicula(int idPelicula){
        String query = "DELETE FROM pelicula WHERE idPelicula = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
            
            int eliminado = ps.executeUpdate();
                if(eliminado == 1){
                    JOptionPane.showMessageDialog(null, "Pelicula eliminada correctamente de la base de datos");                
                }else{
                JOptionPane.showInternalMessageDialog(null, "No se encontro pelicula con ese id");
                }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la pelicula especificada" + e.getMessage());
        }
    
    
    }
    
    public void actualizarPelicula(Pelicula p){
        String query = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, cartelera = ?, rutaImagen = ?"
                + "WHERE idPelicula = ?";
    
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(3, p.getActores());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, Date.valueOf(p.getEstreno()));
            ps.setBoolean(7, p.isCartelera());
            ps.setString(8, p.getRutaImagen());
            
            ps.setInt(9, p.getIdPelicula());
            
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Datos de la pelicula actualizados correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la pelicula");
            }
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + e.getMessage());
        }
    }
    
    
    
}
