/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Modelo.Comprador;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.MyConexion;
import Modelo.Pelicula;
import Modelo.Sala;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FuncionData {
    
    private final Connection conn;
    
    private LugarData lugarData;

    public FuncionData() {
        conn = MyConexion.buscarConexion();
        this.lugarData = new LugarData();
    }
    
     public void guardarFuncion(Funcion funcion) {
        String query = "INSERT INTO Funcion (idPelicula, idioma, es3d, subtitulado, horarioInicio, horarioFin, idSala, precio)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, funcion.getPelicula().getIdPelicula());
            ps.setString(2, funcion.getIdioma());
            ps.setBoolean(3, funcion.isEs3d());
            ps.setBoolean(4, funcion.isSubtitulado());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(funcion.getHoraInicio()));
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(funcion.getHoraFin()));
            
            ps.setInt(7, funcion.getSalaProyeccion().getIdSala());
            ps.setDouble(8, funcion.getPrecio());
            

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                funcion.setIdFuncion(rs.getInt(1));
            
                for (Lugar l : funcion.getListaLugaresDisp()) {
                    
                    String query2 = "UPDATE lugar SET idFuncion = ? WHERE idLugar = ? AND idFuncion = null";
                    
                        PreparedStatement ps2 = conn.prepareStatement(query2);
                        ps2.setInt(1, funcion.getIdFuncion());
                        ps2.setInt(2, l.getIdLugar());
                       
                        ps2.executeUpdate();
                        
                        ps2.close();
                    
                }
                
                ps.close();
                rs.close();
                
                JOptionPane.showMessageDialog(null, "Funcion guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la funcion");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla...: " + e.getMessage());
        }

    }
     
     public void actualizarFuncion(Funcion f) {
        String query = "UPDATE funcion SET idPelicula= ?, idioma = ?, es3d = ?, subtitulado = ?, horarioInicio = ?, horarioFin = ?, idSala = ?, precio = ? WHERE idFuncion = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getPelicula().getIdPelicula());
            ps.setString(2, f.getIdioma());
            ps.setBoolean(3, f.isEs3d());
            ps.setBoolean(4, f.isSubtitulado());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(f.getHoraInicio()));
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(f.getHoraFin()));        
            ps.setInt(8, f.getSalaProyeccion().getIdSala());
            ps.setDouble(9, f.getPrecio());
            
            ps.setInt(10, f.getIdFuncion());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Funcion actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la funcion");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la funcion ");
        }

    }
    
    public void eliminarFuncion(int idFuncion){
       String query = "DELETE FROM funcion WHERE idFuncion = ?";
       
       
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idFuncion);
            int eliminado = ps.executeUpdate();
            
            
            if(eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Funcion eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la funcion con ese ID");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la funcion");
        }
      
  }
    
    public List<Funcion> listarFuncion() {
        List<Funcion> funcion = new ArrayList<>();
        
        //Seleccion de los elementos de la tabla funcion haciendo un JOIN con lugar y pelicula 
        String query = "SELECT f.idFuncion, f.idioma, f.es3d, f.subtitulado, f.horarioInicio, f.horarioFin, f.precio, "
                + "p.idPelicula, p.titulo, p.director, p.actores, p.origen, p.genero, p.estreno, p.cartelera, "
                + "s.idSala, s.nroSala, s.apta3d, s.capacidad, s.estado "
                + "FROM funcion f "
                + "LEFT JOIN pelicula p ON (f.idPelicula = p.idPelicula)"
                + "LEFT JOIN sala s ON (f.idSala = s.idSala)";
         try {
            PreparedStatement ps= conn.prepareStatement(query);
            
            
            
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()) {
                Pelicula p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setActores(rs.getString("actores"));
                p.setOrigen(rs.getString("origen"));
                p.setGenero(rs.getString("genero"));
                p.setEstreno(rs.getDate("estreno").toLocalDate());
                p.setCartelera(rs.getBoolean("cartelera"));
                
                Sala s = new Sala();
                s.setIdSala(rs.getInt("idSala"));
                s.setNroSala(rs.getInt("nroSala"));
                s.setApto3d(rs.getBoolean("apta3d"));
                s.setCapacidad(rs.getInt("capacidad"));
                s.setEstado(rs.getBoolean("estado"));
                
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                f.setIdioma(rs.getString("idioma"));
                f.setEs3d(rs.getBoolean("es3d"));
                f.setSubtitulado(rs.getBoolean("subtitulado"));
                f.setHoraInicio(rs.getTimestamp("horarioinicio").toLocalDateTime());
                f.setHoraFin(rs.getTimestamp("horariofin").toLocalDateTime());
                f.setPrecio(rs.getDouble("precio"));
                
                //se guardan los datos obstenidos de las tablas de pelicula y sala en sus correspondientes valores de la funcion
                f.setPelicula(p);
                f.setSalaProyeccion(s);                           
                
                //obtenemos la lista de los lugares disponibles
                List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(f.getIdFuncion());
                //se recorre la lista
                for (Lugar lugar : lugaresDisponibles) {
                    lugar.setFuncion(f);
                }
                
                //se guarda la lista en la LIST de FUNCION 
                f.setListaLugaresDisp(lugaresDisponibles);
                
                funcion.add(f);
            }
            
            ps.close();
            rs.close();
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error de tabla");
        }
        return funcion;
    }
    
    public Funcion buscarFuncion(int idFuncion){
        Funcion funcion = null;
        
        String query = "SELECT * FROM funcion WHERE idFuncion = ?";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, idFuncion);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                funcion = new Funcion();
                
                funcion.setIdFuncion(rs.getInt("idFuncion"));
                Pelicula pelicula = new Pelicula();
                
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                funcion.setPelicula(pelicula);
                funcion.setIdioma(rs.getString("idioma"));
                funcion.setEs3d(rs.getBoolean("es3d"));
                funcion.setSubtitulado(rs.getBoolean("subtitulado"));
                funcion.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
                funcion.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
                funcion.setPrecio(rs.getDouble("precio"));
                
                
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("idsala"));
                
                funcion.setSalaProyeccion(sala);
                
               String query2 = "SELECT * FROM lugar WHERE idFuncion = ?";
               PreparedStatement ps2 = conn.prepareStatement(query2);
               
               ps2.setInt(1, idFuncion);
               
               ResultSet rs2 = ps2.executeQuery();
               List<Lugar> lugares = new ArrayList();
               
               while(rs2.next()){
                   Lugar l1 = new Lugar();
                   
                   l1.setIdLugar(rs2.getInt("idLugar"));                  
                   l1.setFila(rs2.getString("fila").charAt(0));
                   l1.setNum(rs2.getInt("num"));
                   l1.setEstado(rs2.getBoolean("estado"));
                   
                   lugares.add(l1);
                   
               }
               funcion.setListaLugaresDisp(lugares);
               rs2.close();
               ps2.close();
            }
            
            rs.close();
            ps.close();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        return funcion;
    }
}
