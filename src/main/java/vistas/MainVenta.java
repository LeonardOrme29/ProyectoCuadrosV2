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
        jaGenerarPedido = new javax.swing.JMenu();
        jaAnularVenta = new javax.swing.JMenu();
        jmInventario = new javax.swing.JMenu();
        jaIngreso = new javax.swing.JMenu();
        jaKardex = new javax.swing.JMenu();
        jaAjustes = new javax.swing.JMenu();
        jmAdministracion = new javax.swing.JMenu();
        jaProductos = new javax.swing.JMenu();
        jaInsumos = new javax.swing.JMenu();
        jmReportes = new javax.swing.JMenu();
        jaReportesVentas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));
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

        jaGenerarPedido.setText("GENERAR PEDIDO");
        jaGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaGenerarPedidoActionPerformed(evt);
            }
        });
        jmVentas.add(jaGenerarPedido);

        jaAnularVenta.setText("ANULAR VENTA");
        jmVentas.add(jaAnularVenta);

        jMenuBar1.add(jmVentas);

        jmInventario.setText("INVENTARIO");

        jaIngreso.setText("INGRESO");
        jmInventario.add(jaIngreso);

        jaKardex.setText("KARDEX");
        jmInventario.add(jaKardex);

        jaAjustes.setText("AJUSTES");
        jmInventario.add(jaAjustes);

        jMenuBar1.add(jmInventario);

        jmAdministracion.setText("ADMINISTRACION");

        jaProductos.setText("PRODUCTOS");
        jmAdministracion.add(jaProductos);

        jaInsumos.setText("INSUMOS");
        jmAdministracion.add(jaInsumos);

        jMenuBar1.add(jmAdministracion);

        jmReportes.setText("REPORTES");

        jaReportesVentas.setText("REPORTE DE VENTAS");
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

    private void jaGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaGenerarPedidoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jaGenerarPedidoActionPerformed

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
    private javax.swing.JMenu jaAjustes;
    private javax.swing.JMenu jaAnularVenta;
    private javax.swing.JMenu jaGenerarPedido;
    private javax.swing.JMenu jaIngreso;
    private javax.swing.JMenu jaInsumos;
    private javax.swing.JMenu jaKardex;
    private javax.swing.JMenu jaProductos;
    private javax.swing.JMenu jaReportesVentas;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenu jmVentas;
    // End of variables declaration//GEN-END:variables
}