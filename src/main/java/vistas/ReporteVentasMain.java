/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo.ormeno
 */
public class ReporteVentasMain extends javax.swing.JDialog {
    DefaultTableModel tmodelo;
    private Connection conex;
    /**
     * Creates new form ReporteVentasMain
     */
    public ReporteVentasMain(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Conexion cone=new Conexion();
        conex=cone.conectar();;
        tmodelo = (DefaultTableModel) tReporteVentas.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tReporteVentas = new javax.swing.JTable();
        tfDesde = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        tfHasta = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tReporteVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N. Pedido", "N. Boleta", "Fecha", "Cliente", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tReporteVentas);

        tfDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));
        tfDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesdeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Desde:");

        tfHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));
        tfHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHastaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Hasta:");

        bBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(bBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(tfDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHastaActionPerformed

    private void tfDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDesdeActionPerformed
    public String fechaFormateada(String fechaString){
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate fecha = LocalDate.parse(fechaString, dtfEntrada);

        // Formateador para convertir de LocalDate a YYYY-MM-DD
        DateTimeFormatter dtfSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fecha.format(dtfSalida);
        return fechaFormateada;
    }
    
    public void limpiarTablaCuadros(){        
        tmodelo.setRowCount(0);
    }
    
    public void actualizarTablaVentas(String desde,String hasta){
        System.out.println("TABLA DE REPORTE DE VENTAS");
        System.out.println("Inicio de la Limpieza de la tabla");
        limpiarTablaCuadros();
        System.out.println("Fin de la limpieza de la tabla");
        try {
            System.out.println("rellenar tabla");
            String sSQL = "{CALL busqueda_reporte_main(?,?) }";
            CallableStatement cstmt = conex.prepareCall(sSQL);
            cstmt.setString(1, desde);
            cstmt.setString(2, hasta);
            ResultSet res = cstmt.executeQuery();
            // Manejar los resultados obtenidos
            while (res.next()) {
                // Obtener los detalles del pedido desde el ResultSet
                ArrayList<Object> fila = new ArrayList<>();
                fila.add(res.getString("N_PEDIDO"));
                fila.add(res.getString("bol_des"));
                fila.add(res.getString("fecha"));
                fila.add(res.getString("old_cliente"));
                fila.add((Object) res.getFloat("precio"));
                // Agregar la fila al modelo de tabla
                tmodelo.addRow(fila.toArray());
            }
            // Cerrar el ResultSet y el CallableStatement
            res.close();
            cstmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        String desde=fechaFormateada(tfDesde.getText());
        String hasta=fechaFormateada(tfHasta.getText());
        actualizarTablaVentas(desde,hasta);
    }//GEN-LAST:event_bBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteVentasMain dialog = new ReporteVentasMain(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tReporteVentas;
    private javax.swing.JFormattedTextField tfDesde;
    private javax.swing.JFormattedTextField tfHasta;
    // End of variables declaration//GEN-END:variables
}
