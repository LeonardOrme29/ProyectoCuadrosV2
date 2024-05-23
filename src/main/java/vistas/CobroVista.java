/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.BoletaController;

/**
 *
 * @author leonardo.ormeno
 */
public class CobroVista extends javax.swing.JDialog {
    private Connection conex;
    private int idpedido;
    private String name;
    /**
     * Creates new form CobroVista
     */
    public CobroVista(java.awt.Frame parent, boolean modal, int idpedido,String name) {
        super(parent, modal);
        initComponents();
        Conexion cone=new Conexion();
        conex=cone.conectar();
        this.idpedido=idpedido;
        this.name=name;
        llenarDetallesPedido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        detallesLabel = new javax.swing.JLabel();
        bPagar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        detallesLabel.setText("Cargando...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(detallesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(detallesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPagar.setText("PAGAR");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        jButton1.setText("RESERVAR PEDIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(bPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        // TODO add your handling code here:
        //CREACION DEL vta_cab
        BoletaController bc1=new  BoletaController(conex);
        try {
            String procedimiento = "{ CALL pagar_vta_cab(?,?,?,?,?) }";
            try (CallableStatement cs = conex.prepareCall(procedimiento)) {
                // Establecer el parámetro de entrada del procedimiento
                cs.setInt(1,idpedido);
                cs.setString(2, "B");
                cs.setString(3,bc1.getCorrelativo());
                cs.setString(4,bc1.getNumBoleta());
                cs.setString(5, name);
                // Ejecutar el procedimiento
                ResultSet rs = cs.executeQuery();
                // Obtener el valor del parámetro de salida
                JOptionPane.showMessageDialog(null, "SE REALIZO LA VENTA!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e, "Error realizar el proceso de cobro", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_bPagarActionPerformed
    
    private void llenarDetallesPedido() {
        ArrayList<String> listaCuadros=new ArrayList();
        try {
            String sSQL = "{CALL list_cuadros_pedido(?) }";
            CallableStatement cstmt = conex.prepareCall(sSQL);
            cstmt.setInt(1, idpedido);
            ResultSet rs = cstmt.executeQuery();
            // Manejar los resultados obtenidos
            while (rs.next()) {
                // Obtener los detalles del pedido desde el ResultSet
                String des = rs.getString("des");
                String cant = rs.getString("cant");
                String precio = rs.getString("precio");
                listaCuadros.add(des+" | "+cant+" | "+precio);
            }

            // Cerrar el ResultSet y el CallableStatement
            rs.close();
            cstmt.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,e, "Error en llenar datos del pedido", JOptionPane.ERROR_MESSAGE);
        }
        //LLENAR EL LABEL
        String s="";
        for (int i=0;i<listaCuadros.size();i++){
            s+="<p>"+listaCuadros.get(i)+"</p>";
        }
        System.out.println(s);
        detallesLabel.setText("<html><body>"+s+"</body></hmtl>");
    }
    

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
            java.util.logging.Logger.getLogger(CobroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        int id=0;
        String name="error";
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CobroVista dialog = new CobroVista(new javax.swing.JFrame(), true,id,name);
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
    private javax.swing.JButton bPagar;
    private javax.swing.JLabel detallesLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
