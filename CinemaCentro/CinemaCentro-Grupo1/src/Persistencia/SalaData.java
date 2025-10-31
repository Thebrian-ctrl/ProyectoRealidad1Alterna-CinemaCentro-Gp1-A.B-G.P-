/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.MyConexion;
import Modelo.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author paula
 */
public class SalaData {
    
      private final Connection conn;
      
      public SalaData(){
          conn = MyConexion.buscarConexion();
      }
    
    
      
      public void guardarSala(Sala sala){
          String query= "INSERT INTO sala (nroSala ,apta3d ,capacidad ,estado) VALUES (?, ?, ?, ?)";
       try{
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, sala.getNroSala());
            ps.setBoolean(2, sala.isApto3d());
            ps.setInt(3, sala.getCapacidad());
            ps.setBoolean(4, sala.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            
            
            if(rs.next()){
                sala.setIdSala(rs.getInt(1));
                
                JOptionPane.showMessageDialog(null, "Sala guardada correctamente");
            }else {
                JOptionPane.showMessageDialog(null,"Error al guardar la sala");
            }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ");
       }
      }
      
      
      public Sala buscarSala(int idSala){
          Sala sala=null;
          String query= "SELECT* FROM sala WHERE idSala= ?";
          try{
              PreparedStatement ps= conn.prepareStatement(query);
              
              ps.setInt(1, idSala);
              ResultSet rs= ps.executeQuery();
              
              if(rs.next()){
                  sala = new Sala();
                  sala.setIdSala(rs.getInt("idSala"));
                  sala.setNroSala(rs.getInt("nroSala"));
                  sala.setApto3d(rs.getBoolean("apta3d"));
                  sala.setCapacidad(rs.getInt("capacidad"));
                  sala.setEstado(rs.getBoolean("estado"));
              }else{
                  JOptionPane.showMessageDialog(null, "no se encontro la sala con ID: "+idSala);
              }
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "error al buscar la Sala ");
          }
          
          return sala;
      }
      
      
       public List<Sala> listarSalas() {
        List<Sala> salas = new ArrayList<>();
        String query = "SELECT * FROM sala";
        try  {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sala s = new Sala();
                s.setIdSala(rs.getInt("idSala"));
                s.setNroSala(rs.getInt("nroSala"));
                s.setApto3d(rs.getBoolean("apta3d"));
                s.setCapacidad(rs.getInt("capacidad"));
                s.setEstado(rs.getBoolean("estado"));
                salas.add(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar salas: " + e.getMessage());
        }
        return salas;
    }
      
      
      public void darBajaSala(int idSala){
        String query = "UPDATE sala SET estado = false WHERE idSala = ?";
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idSala);
                
                int actualizado = ps.executeUpdate();
                
                if(actualizado == 1){
                    JOptionPane.showMessageDialog(null, "Sala dada de baja correctamente");                           
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro sala con el id especificado");                    
                }
                ps.close();                                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la sala: " + e.getMessage());
        }   
    }
    
    
    public void darAltaSala(int idSala){
        String query = "UPDATE sala SET estado = true WHERE idSala = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idSala);
             
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Sala dada de alta correctamente");           
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro Sala con el id especificado");
            }
                ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta la Sala: " + e.getMessage());
            
        }
    
    
    }
    
    
     public void actualizarSala(Sala s) {
        String query = "UPDATE sala SET nroSala = ?, apta3d = ?, capacidad = ?, estado = ? WHERE idSala = ?";
        try {
            
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            
            ps.setInt(1, s.getNroSala());
            ps.setBoolean(2, s.isApto3d());
            ps.setInt(3, s.getCapacidad());
            ps.setBoolean(4, s.isEstado());
            ps.setInt(5, s.getIdSala());

            int actualizado = ps.executeUpdate();
            
            
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Sala actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la sala");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar sala ");
        }
    }

   
    public void eliminarSala(int idSala) {
        String query = "DELETE FROM sala WHERE idSala = ?";
        
        try  {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idSala);
            int eliminado = ps.executeUpdate();
            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Sala eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró sala con ese ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar sala ");
        }
    }
    
    
    public boolean existeNumeroSala(int nroSala) {
        
        
    String query = "SELECT COUNT(*) FROM sala WHERE nroSala = ?";
    
    
    try  {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, nroSala);
        ResultSet rs = ps.executeQuery();
        
        
        if (rs.next()) {
            int cantidad = rs.getInt(1);
            return cantidad > 0; // Si existe al menos una, devuelve true
        }
        
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al verificar número de sala: " + e.getMessage());
    }
    return false;
    }
    
    
    public boolean existeNumeroSalaExcluyendoId(int nroSala, int idSala) {
    String query = "SELECT COUNT(*) FROM sala WHERE nroSala = ? AND idSala <> ?";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1, nroSala);
        ps.setInt(2, idSala);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // true si existe otra sala con ese número
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al verificar número de sala: " + e.getMessage());
    }
    return false;
    }

    
      
    
}
