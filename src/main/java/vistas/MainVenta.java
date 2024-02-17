/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author leonardo.ormeno
 */
public class MainVenta extends javax.swing.JFrame {

    /**
     * Creates new form MainVenta
     */
    public MainVenta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmVentas = new javax.swing.JMenu();
        jaGenerarVenta = new javax.swing.JMenuItem();
        jaAnularVenta = new javax.swing.JMenuItem();
        jmInventario = new javax.swing.JMenu();
        jaKardex = new javax.swing.JMenuItem();
        jaIngreso = new javax.swing.JMenuItem();
        jaAjuste = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jaProductos = new javax.swing.JMenuItem();
        jaMateriales = new javax.swing.JMenuItem();
        jmReportes = new javax.swing.JMenu();
        jaReportesVentas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 480));

        jmVentas.setText("VENTAS");
        jmVentas.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                jmVentasMenuKeyTyped(evt);
            }
        });
        jmVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVentasActionPerformed(evt);
            }
        });

        jaGenerarVenta.setText("GENERAR VENTA");
        jaGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaGenerarVentaActionPerformed(evt);
            }
        });
        jmVentas.add(jaGenerarVenta);

        jaAnularVenta.setText("ANULAR VENTA");
        jmVentas.add(jaAnularVenta);

        jMenuBar1.add(jmVentas);

        jmInventario.setText("INVENTARIO");

        jaKardex.setText("KARDEX");
        jaKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaKardexActionPerformed(evt);
            }
        });
        jmInventario.add(jaKardex);

        jaIngreso.setText("INGRESO");
        jmInventario.add(jaIngreso);

        jaAjuste.setText("AJUSTE");
        jmInventario.add(jaAjuste);

        jMenuBar1.add(jmInventario);

        jmAdministracion.setText("ADMINISTRACION");

        jaProductos.setText("PRODUCTOS");
        jmAdministracion.add(jaProductos);

        jaMateriales.setText("MATERIALES");
        jaMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaMaterialesActionPerformed(evt);
            }
        });
        jmAdministracion.add(jaMateriales);

        jMenuBar1.add(jmAdministracion);

        jmReportes.setText("REPORTES");

        jaReportesVentas.setText("REPORTE DE VENTAS");
        jaReportesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaReportesVentasActionPerformed(evt);
            }
        });
        jmReportes.add(jaReportesVentas);

        jMenuBar1.add(jmReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmVentasMenuKeyTyped(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jmVentasMenuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jmVentasMenuKeyTyped

    
    private void jmVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVentasActionPerformed

    }//GEN-LAST:event_jmVentasActionPerformed

    private void jaReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaReportesVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaReportesVentasActionPerformed

    private void jaMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaMaterialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaMaterialesActionPerformed

    private void jaKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaKardexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaKardexActionPerformed

    private void jaGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaGenerarVentaActionPerformed
        // TODO add your handling code here:
        DVentas dventas=new DVentas(this,true);
        dventas.setLocationRelativeTo(this);
        dventas.setVisible(true);
    }//GEN-LAST:event_jaGenerarVentaActionPerformed

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
            java.util.logging.Logger.getLogger(MainVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jaAjuste;
    private javax.swing.JMenuItem jaAnularVenta;
    private javax.swing.JMenuItem jaGenerarVenta;
    private javax.swing.JMenuItem jaIngreso;
    private javax.swing.JMenuItem jaKardex;
    private javax.swing.JMenuItem jaMateriales;
    private javax.swing.JMenuItem jaProductos;
    private javax.swing.JMenuItem jaReportesVentas;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenu jmVentas;
    // End of variables declaration//GEN-END:variables
}
