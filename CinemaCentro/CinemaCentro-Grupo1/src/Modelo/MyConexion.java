/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author arceb
 */
public class MyConexion {
     private static Connection con;
   
    
    public static Connection buscarConexion(){
    if(con == null){
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost/cinemacentro-grupo1", "root", "");
            JOptionPane.showMessageDialog(null, "Base de datos conectada exitosamente");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Driver de conexion" + ex.getMessage());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectar base de datos" + e.getMessage());
        }
    
    }
    return con;
    }
}
