/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Pelicula;
import Persistencia.PeliculaData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author paula
 */
public class PanelItemPeliculaEstreno extends javax.swing.JPanel {

    /**
     * Creates new form PanelItemPeliculaEstreno
     */
     private Pelicula pelicula;
    private PeliculaData peliData;
    public PanelItemPeliculaEstreno(Pelicula pelicula, PeliculaData peliData) {
        
        
         this.pelicula = pelicula;
        this.peliData = peliData;
        
        //---------------------------Imagen-----------------------------------------------
        this.setLayout(new BorderLayout(10,10));
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        
        JLabel labelImagen = new JLabel();
        
        try {
            ImageIcon icono = new ImageIcon(pelicula.getRutaImagen());
            Image img = icono.getImage().getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
            labelImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            labelImagen.setText("Sin imagen");
        }
        this.add(labelImagen, BorderLayout.WEST);
        
        //-----------------------------datos-------------------------------------------------
        
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        
        JLabel labelTitulo = new JLabel(pelicula.getTitulo());
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        
        JLabel labelDirector = new JLabel("Director: " + pelicula.getDirector());
        JLabel labelGenero = new JLabel("Genero: " + pelicula.getGenero());
        JLabel labelActores = new JLabel("Actores: " + pelicula.getActores());
        JLabel labelOrigen = new JLabel("Origen: " + pelicula.getOrigen());
        JLabel labelEstreno = new JLabel("Fecha de estreno: " + pelicula.getEstreno());
        
        panelDatos.add(labelTitulo);
        panelDatos.add(labelDirector);
        panelDatos.add(labelGenero);
        panelDatos.add(labelActores);
        panelDatos.add(labelOrigen);
        panelDatos.add(labelEstreno);
        
        this.add(panelDatos, BorderLayout.CENTER);
        
        //--------------------------acciones-------------------------------------------------
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonBaja = new JButton("Dar de baja" );
        JButton botonAlta = new JButton("Dar de alta");
        JButton actualizarBtn = new JButton("Actualizar");
        
     
        panelBotones.add(botonAlta);
       
        
        
       
        
        botonEliminar.addActionListener(e ->{
            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar esta pelicula de la base de datos?",
                     "Confirmar Eliminicion", JOptionPane.YES_NO_OPTION);
                
                 if(opcion == JOptionPane.YES_OPTION) {
                     peliData.eliminarPelicula(pelicula.getIdPelicula());
                     
                
            }
        });
        
        botonBaja.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Dar de baja a la pelicula en cartelera?",
                     "Confirmar baja", JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                pelicula.setCartelera(false);
                peliData.darBajaCartelera(pelicula.getIdPelicula());
                
            }
            
        });
        
        botonAlta.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Dar de alta a la pelicula?",
                    "Confirmar suba a cartelera", JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                pelicula.setCartelera(false);
                peliData.darAltaCartelera(pelicula.getIdPelicula());
            }
        });
        
        actualizarBtn.addActionListener(e -> {
            JDesktopPane desktopPane = (JDesktopPane) SwingUtilities.getAncestorOfClass(JDesktopPane.class, this);
            
            if(desktopPane != null){
                PantallaPeliculas pelis = new PantallaPeliculas();
                desktopPane.add(pelis);
                pelis.setVisible(true);
                
                pelis.setLocation(
                        (desktopPane.getWidth() - pelis.getWidth()) / 2,
                        (desktopPane.getHeight() - pelis.getHeight()) / 2
                );
            }
        
        });
        
          
        this.add(panelBotones, BorderLayout.EAST);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
