/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import javax.swing.*;
import java.util.*;
import javax.swing.DefaultListModel;
import java.time.LocalDateTime;
import Modelo.*;          
import Persistencia.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author camila biarnes
 */
public class CompraTicket extends javax.swing.JInternalFrame {

     private PeliculaData peliculaData;
    private FuncionData funcionData;
    private LugarData lugarData;
    private CompradorData compradorData;
    private TicketCompraData ticketData;
    private DetalleTicketData detalleData;
    
    private List<Pelicula> peliculas;
    private List<Funcion> funciones;
    private Funcion funcionSeleccionada;
    private List<Lugar> lugaresSeleccionados;
    
    private DefaultListModel<String> modeloLista;

    public CompraTicket() {
        initComponents();
         inicializar();
        
    
}
   
     private void inicializar() {
         peliculaData = new PeliculaData();
        funcionData = new FuncionData();
        lugarData = new LugarData();
        compradorData = new CompradorData();
        ticketData = new TicketCompraData();
        detalleData = new DetalleTicketData();
        
         lugaresSeleccionados = new ArrayList<>();
        modeloLista = new DefaultListModel<>();
        jList2.setModel(modeloLista);
        
         jSpinField1.setMinimum(1);
        jSpinField1.setMaximum(10);
        jSpinField1.setValue(1);
        
          cargarPeliculas();
          jComboBox1.addActionListener(e -> cargarFunciones());
        jComboBox2.addActionListener(e -> cargarLugares());
        jList2.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarLugares();
            }
        });
     }
     
      private void cargarPeliculas() {
        jComboBox1.removeAllItems();
        peliculas = peliculaData.listarPeliculasCartelera();
        
        for (Pelicula p : peliculas) {
            jComboBox1.addItem(p.getTitulo());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPelicula = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelFuncion = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabelCantEntradas = new javax.swing.JLabel();
        jLabelSelecAsientos = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnComprar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("COMPRA DE ENTRADAS");

        jLabelPelicula.setText("Seleccione Pelicula:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelFuncion.setText("Seleccione Funcion:");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("INFORMACION DE LA FUNCION ");

        jLabelCantEntradas.setText("Cantidad de Entradas");

        jLabelSelecAsientos.setText("Seleccion de Asientos");

        jScrollPane3.setViewportView(jList2);

        jLabelPrecio.setText("Precio por entrada: $10.000");

        jLabelTotal.setText("TOTAL: ");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnComprar.setText("Comprar");
        BtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComprarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPelicula)
                            .addComponent(jLabelFuncion)
                            .addComponent(jLabel2)
                            .addComponent(jLabelCantEntradas)
                            .addComponent(jLabelSelecAsientos)
                            .addComponent(jLabelPrecio)
                            .addComponent(jLabelTotal)
                            .addComponent(BtnCancelar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(BtnComprar)
                                .addGap(87, 87, 87)
                                .addComponent(BtnLimpiar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPelicula)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFuncion)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCantEntradas))
                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSelecAsientos)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabelPrecio)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotal)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnComprar)
                    .addComponent(BtnLimpiar))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
  int opcion = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro que desea cancelar la compra?", 
            "Confirmar Cancelación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            limpiarFormulario();
            this.dispose();
        }
    
    }//GEN-LAST:event_BtnCancelarActionPerformed

   
    
    private void BtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComprarActionPerformed
if (jComboBox1.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una película");
            return;
        }

if (jComboBox2.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una función");
            return;
        }
int cantidad = jSpinField1.getValue();
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0");
            return;
        }
                                      
    }//GEN-LAST:event_BtnComprarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
       int opcion = JOptionPane.showConfirmDialog(
            this, 
            "¿Desea limpiar todos los campos?", 
            "Confirmar Limpieza", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Formulario limpiado correctamente", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
                                     
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    private void limpiarFormulario() {
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.removeAllItems();
        modeloLista.clear();
        jSpinField1.setValue(1);
        jLabelPrecio.setText("Precio por entrada: $10.0000");
        jLabelTotal.setText("TOTAL: $0.00");
        lugaresSeleccionados.clear();
        funcionSeleccionada = null;
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnComprar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantEntradas;
    private javax.swing.JLabel jLabelFuncion;
    private javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelSelecAsientos;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.components.JSpinField jSpinField1;
    // End of variables declaration//GEN-END:variables

    private void cargarFunciones() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void cargarLugares() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void seleccionarLugares() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

