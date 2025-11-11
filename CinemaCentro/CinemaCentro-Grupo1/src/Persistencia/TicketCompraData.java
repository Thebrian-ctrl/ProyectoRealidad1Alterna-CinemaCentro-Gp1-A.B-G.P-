
package Persistencia;

import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.MyConexion;
import Modelo.TicketCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList; 
import java.time.LocalDate;
import java.util.List;



/**
 *
 * @author camila biarnes
 */
public class TicketCompraData {
    
    private final Connection conn;
    
    public TicketCompraData() {
        conn = MyConexion.buscarConexion();
    }
    

    public void guardarTicketCompra(TicketCompra ticket) {
        String query = "INSERT INTO ticket (fechaCompra, fechaFuncion, monto, idComprador, idDetalleTicket) "
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(ticket.getFechaCompra()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ticket.getFechaFuncion()));
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getComprador().getIdComprador());
            
            if (ticket.getDetalleticket() != null) {
                ps.setInt(5, ticket.getDetalleticket().getIdDetalleTicket());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                ticket.setIdTicket(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ticket de compra guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el Ticket de compra");
            }
            
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla " + e.getMessage());
        }
    }
    
 
    public TicketCompra buscarTickerporId (int idTicket) {
        TicketCompra ticket = null;
        String query = "SELECT * FROM ticket WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idTicket);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
               
                Comprador comprador = new Comprador();
                comprador.setIdComprador(rs.getInt("idComprador"));
                ticket.setComprador(comprador);
                
             
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicket detalle = new DetalleTicket();
                    detalle.setIdDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ticket con ID: " + idTicket);
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el ticket: " + e.getMessage());
        }
        
        return ticket;
    }
    

    public void actualizarTicket(TicketCompra ticket) {
        String query = "UPDATE ticket SET fechaCompra = ?, fechaFuncion = ?, monto = ?, "
                + "idComprador = ?, idDetalleTicket = ? WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setDate(1, Date.valueOf(ticket.getFechaCompra()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ticket.getFechaFuncion()));
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getComprador().getIdComprador());
            
            if (ticket.getDetalleticket() != null) {
                ps.setInt(5, ticket.getDetalleticket().getIdDetalleTicket());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.setInt(6, ticket.getIdTicket());
            
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el ticket");
            }
            
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Ticket " + e.getMessage());
        }
    }
    
    
    public void anularTicket (int idTicket) {
     String query = "DELETE FROM ticket WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idTicket);
            
            int eliminado = ps.executeUpdate();
            
            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Ticket anulado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ticket con ese ID");
            }
            
            ps.close ();
         
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al anular el ticket" + e.getMessage());
       }
    }
    
    // listo los tickets por fecha 
    
    public List<TicketCompra> listarTicketsPorFecha (LocalDate fecha) {
        List <TicketCompra> tickets = new ArrayList <> ();
        String query = "SELECT * FROM ticket WHERE fechacompra = ?" ;
        
        try {
            PreparedStatement ps = conn.prepareStatement (query) ;
            ps.setDate (1, Date.valueOf(fecha));
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
                Comprador comprador = new Comprador ();
                comprador.setIdComprador(rs.getInt("idComprador"));
                
                int idDetalle = rs.getInt ("IdDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicket detalle = new DetalleTicket ();
                    detalle.setIdDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add (ticket);
            }
            
            rs.close ();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar tickets"+ e.getMessage());
        }
        return tickets;
    }
  
    // listo los tickets por pelicula 
    
    public List <TicketCompra> ListarTicketsPorPelicula (int idPelicula ) {
        List <TicketCompra> tickets = new ArrayList <> ();
         CompradorData compradorData = new CompradorData();
         DetalleTicketData detalleData = new DetalleTicketData();
        String query = "SELECT DISTINCT t.* FROM ticket t "
            + "INNER JOIN detalleticket d ON t.idDetalleTicket = d.idDetalleTicket "
            + "INNER JOIN funcion f ON d.idFuncion = f.idFuncion "
            + "WHERE f.idPelicula = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement (query);
            ps.setInt (1,idPelicula);
            
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
                Comprador comprador = new Comprador();
                comprador = compradorData.buscarCompradorPorId(rs.getInt("idComprador"));
                
                
                ticket.setComprador(comprador);
                
                DetalleTicket detalle = detalleData.buscarDetalleTicket(rs.getInt("idDetalleTicket"));
                ticket.setDetalleticket(detalle);
                tickets.add(ticket);
             }
             rs.close();
             ps.close ();
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar tickets por película: " + e.getMessage());
        }
            
            return tickets;
        }
                
    // seguir listando tickets x comprador 
     public List<TicketCompra> listarTicketsPorComprador(int idComprador) {
        List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticket WHERE idComprador = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idComprador);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
                Comprador comprador = new Comprador();
                comprador.setIdComprador(rs.getInt("idComprador"));
                ticket.setComprador(comprador);
                
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicket detalle = new DetalleTicket();
                    detalle.setIdDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar tickets por comprador: " + e.getMessage());
        }
        
        return tickets;
    }
    
   
    public List<TicketCompra> listarTodosTickets() {
        List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticket";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
                Comprador comprador = new Comprador();
                comprador.setIdComprador(rs.getInt("idComprador"));
                ticket.setComprador(comprador);
                
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicket detalle = new DetalleTicket();
                    detalle.setIdDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar todos los tickets: " + e.getMessage());
        }
        
        return tickets;
    }
    
  
}