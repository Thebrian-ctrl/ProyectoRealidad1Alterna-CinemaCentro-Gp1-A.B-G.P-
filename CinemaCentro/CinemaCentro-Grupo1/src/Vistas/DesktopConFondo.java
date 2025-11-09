/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author arceb
 */
public class DesktopConFondo extends JDesktopPane{
    private Image imagenFondo;
    
    public DesktopConFondo(){
        super();
        
        try {
            imagenFondo = new ImageIcon(getClass().getResource("/img/cinema2.jpg")).getImage();
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen de fondo" + e.getMessage());
            setBackground(Color.gray);
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(imagenFondo != null){
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
