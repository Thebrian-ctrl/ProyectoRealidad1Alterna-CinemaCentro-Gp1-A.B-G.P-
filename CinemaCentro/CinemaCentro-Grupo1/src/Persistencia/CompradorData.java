/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Comprador;
import Modelo.MyConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author paula
 */

public class CompradorData {
    
  private final Connection conn;

    public CompradorData() {
       conn = MyConexion.buscarConexion();
    }
  
  
  public void guardarComprador(Comprador compra){
      String query= "INSERT INTO comprador(dni, nombre, password, medioDePago, fechaNacimiento) VALUES(?, ?, ?, ?, ?)";
     
      
       try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
          
            
            
            
            ps.setInt(1, compra.getDni());
            ps.setString(2, compra.getNombre());
            ps.setString(3, compra.getPassword());
            ps.setString(4, compra.getMedioDePago());
            ps.setDate(5, Date.valueOf(compra.getFechaNac()));

            ps.executeUpdate();


            
            
            ResultSet rs = ps.getGeneratedKeys();
            
             if(rs.next()) {
                compra.setIdComprador(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comprador guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el comprador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }
      
      
      
      
  }
  
  //--------------------buscar comprador por dni 
  
  public Comprador buscarComprador(int dni){
        Comprador c = null;
        String query = "SELECT * FROM comprador WHERE dni = ?";
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
             ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            
            
            
            if(rs.next()) {
                c = new Comprador();
                c.setIdComprador(rs.getInt("idComprador"));
                c.setDni(rs.getInt("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setPassword(rs.getString("password"));
                c.setMedioDePago(rs.getString("medioDePago"));
                c.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el comprador con DNI " + dni);
            }
        
        
        
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error al buscar el Comprador");
            
        }
        return c;
  }
  
  
  
  public void actualizarComprador(Comprador c){
      String query = "UPDATE comprador SET dni = ?, nombre = ?, password = ?, medioDePago = ?, fechaNacimiento = ? WHERE idComprador = ?";
  
  
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getMedioDePago());
            ps.setDate(5, Date.valueOf(c.getFechaNac()));
            ps.setInt(6, c.getIdComprador());

            int actualizado = ps.executeUpdate();
            
            
            
            if(actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Datos del comprador actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el comprador");
            }
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar comprador " );
        }
  
  
  
  }
  
  
  public void eliminarComprador(int idComprador){
       String query = "DELETE FROM comprador WHERE idComprador = ?";
       
       
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idComprador);
            int eliminado = ps.executeUpdate();
            
            
            if(eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Comprador eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró comprador con ese ID");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el comprador");
        }
      
  }
  
  
   // Listar todos los compradores
    public List<Comprador> listarCompradores() {
        List<Comprador> compradores = new ArrayList<>();
        String query = "SELECT * FROM comprador";
         try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()) {
                Comprador c = new Comprador();
                c.setIdComprador(rs.getInt("idComprador"));
                c.setDni(rs.getInt("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setPassword(rs.getString("password"));
                c.setMedioDePago(rs.getString("medioDePago"));
                c.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                compradores.add(c);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar compradores: " + e.getMessage());
        }
        return compradores;
    }
    
    
    public Comprador buscarCompradorPorId(int idComprador) {
    Comprador comprador = null;
    String sql = "SELECT * FROM comprador WHERE idComprador = ?";

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idComprador);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            comprador = new Comprador();
            comprador.setIdComprador(rs.getInt("idComprador"));
            comprador.setDni(rs.getInt("dni"));
            comprador.setNombre(rs.getString("nombre"));
            comprador.setPassword(rs.getString("password"));
            comprador.setMedioDePago(rs.getString("medioDePago"));
            comprador.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
        }

        rs.close();
        ps.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar comprador por ID: " + e.getMessage());
    }

    return comprador;
}
  
  
  
  
  

    
}
