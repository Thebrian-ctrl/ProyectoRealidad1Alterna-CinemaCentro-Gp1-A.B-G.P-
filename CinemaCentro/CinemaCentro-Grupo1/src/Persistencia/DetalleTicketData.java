/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DetalleTicket;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.MyConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DetalleTicketData {

    private final Connection conn;

    public DetalleTicketData() {
        conn = MyConexion.buscarConexion();
    }

    

    public void guardarDetalleTicket(DetalleTicket detalle) {
        String query = "INSERT INTO detalleTicket (idFuncion, idLugar, cantidad, subtotal)"
                + " VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, detalle.getFuncion().getIdFuncion());
            ps.setInt(2, detalle.getLugar().getIdLugar());
            
            if(detalle.getCantidad() != null){
                ps.setInt(3, detalle.getCantidad().getIdLugar());
                }else{
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            
            
            ps.setDouble(4, detalle.getSubtotal());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                detalle.setIdDetalleTicket(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "DetalleTicket guardado correctamente");
                
               
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el DetalleTicket");
            }
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }
        

    }

  public void actualizarDetalleTicket(DetalleTicket d) {
    String query = "UPDATE detalleticket SET idFuncion = ?, idLugar = ?, cantidad = ?, subtotal = ? WHERE idDetalleTicket = ?";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, d.getFuncion().getIdFuncion());

        // Primer lugar (siempre asumimos que no es null)
        
        if(d.getLugar()!= null){
             ps.setInt(2, d.getLugar().getIdLugar());
        }else {
            ps.setNull(2, java.sql.Types.INTEGER);
        }
       

        // Segundo lugar: puede ser null
        if (d.getCantidad() != null) {
            ps.setInt(3, d.getCantidad().getIdLugar());
        } else {
            ps.setNull(3, java.sql.Types.INTEGER);
        }

        ps.setDouble(4, d.getSubtotal());
        ps.setInt(5, d.getIdDetalleTicket());

        int actualizado = ps.executeUpdate();

        if (actualizado == 1) {
            JOptionPane.showMessageDialog(null, "Datos del detalleticket actualizados correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el detalleticket");
        }

        ps.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar el detalleticket");
    }
}

    public void eliminarDetalleTicket(int idDetalleTicket) {
        String query = "DELETE FROM detalleticket WHERE idDetalleTicket = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idDetalleTicket);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "DetalleTicket eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el detalleticket con ese ID");
            } ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalleticket");
        }

    }

    public DetalleTicket buscarDetalleTicket(int id) {
         System.out.println("Buscando detalle con ID: " + id);
        String query = "SELECT * FROM detalleticket WHERE idDetalleTicket = ?";

        DetalleTicket detalle = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                detalle = new DetalleTicket();

                detalle.setIdDetalleTicket(rs.getInt("idDetalleTicket"));
                //detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setSubtotal(rs.getDouble("subtotal"));
                
                
                FuncionData funcionData= new FuncionData();
                Funcion funcion = funcionData.buscarFuncionPorId(rs.getInt("idFuncion"));
               // funcion.setIdFuncion(rs.getInt("idFuncion"));
                detalle.setFuncion(funcion);

                 LugarData lugarData = new LugarData();
                Lugar lugar = lugarData.buscarLugarPorId(rs.getInt("idLugar"));
                detalle.setLugar(lugar);
                
                 int idLugarCantidad = rs.getInt("cantidad");
                    if (!rs.wasNull()) {
                    Lugar lugar2 = lugarData.buscarLugarPorId(idLugarCantidad);
                    detalle.setCantidad(lugar2);
                     } else {
                    detalle.setCantidad(null);
                     }
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el detalleticket");
            }
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el detalleticket");
        }
        return detalle;
    }
    public List<Lugar> buscarLugaresPorDetalleTicket(int idDetalleTicket) {
    List<Lugar> lugares = new ArrayList<>();

    String sql = "SELECT idLugar, cantidad FROM detalleticket WHERE idDetalleTicket = ?";

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idDetalleTicket);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int idLugar1 = rs.getInt("idLugar");
            int idLugar2 = rs.getInt("cantidad"); // este también es un idLugar

            LugarData lugarData = new LugarData();

            // buscar y agregar el primer lugar
            Lugar lugar1 = lugarData.buscarLugarPorId(idLugar1);
            if (lugar1 != null) lugares.add(lugar1);

            // buscar y agregar el segundo lugar (si existe)
            Lugar lugar2 = lugarData.buscarLugarPorId(idLugar2);
            if (lugar2 != null) lugares.add(lugar2);
        }

        rs.close();
        ps.close();

    } catch (Exception e) {
        System.out.println("Error al buscar lugares por detalle ticket: " + e.getMessage());
    }

    return lugares;
}
    
    
   
}
