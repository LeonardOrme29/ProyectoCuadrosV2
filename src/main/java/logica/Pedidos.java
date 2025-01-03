/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import conexion.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Timestamp; 
import java.sql.Types;

/**
 *
 * @author leonardo.ormeno
 */
public class Pedidos {
    private Connection conex;
    //private int id_pedido;
    private String n_pedido;
    private String ant_n_pedido;
    private int idPedido;
    
    public Pedidos(){
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }

    public void setN_pedido(String n_pedido) {
        this.n_pedido = n_pedido;
    }

    public String getN_pedido() {
        return n_pedido;
    }

    public int getIdPedido() {
        return idPedido;
    }
    
    public String calcAnteriorPedido(){
        String anterior_pedido=null;
        try{
                String sSQL="SELECT id_pedido,N_PEDIDO FROM pedido WHERE id_pedido=(SELECT MAX(id_pedido) FROM pedido)";
                Statement cn=conex.createStatement();
                ResultSet res=cn.executeQuery(sSQL);
                while(res.next()){
                    anterior_pedido=res.getString("N_PEDIDO");
                   //idPedido=1+Integer.parseInt(res.getString("id_pedido"));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println(e);
            }
        return anterior_pedido;
    }
    public String autoincremental(String anterior_pedido){
        int intAntPedido=Integer.parseInt(anterior_pedido);
        intAntPedido+=1;
        return String.format("%06d", intAntPedido);
        //System.out.println(n_pedido);            
    }
    
    public String calcNPedido(){
        String sig_pedido=autoincremental(calcAnteriorPedido());
        System.out.println(sig_pedido);
        setN_pedido(sig_pedido);
        return sig_pedido;
    }
    
    public boolean verificarPedidoCreado(String nroPedido){ //CON EL NUEVO STORE PROCEDURE YA NO SERA NECESARIO YA QUE SI EXISTE ARROJA EL VALOR DE -1
        String sSQL="SELECT id_pedido FROM pedido WHERE N_PEDIDO="+nroPedido+";";
        try{
            Statement st=conex.createStatement();
            ResultSet res=st.executeQuery(sSQL);
            if(res.next()){
                //idPedido=res.getInt("id_pedido");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Error al verificar el cobro.", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void crearPedido(String nroPedido){
        if(!verificarPedidoCreado(nroPedido)){
            String spSQL="{CALL pedido_crearPedido(?,?)}";
            try {
                CallableStatement cs=conex.prepareCall(spSQL);
                cs.setString(1,nroPedido);
                cs.registerOutParameter(2, Types.INTEGER);
                cs.execute();
                idPedido=cs.getInt(2);
                if (idPedido!=0) {
                    System.out.println("Se creo un nuevo registro de pedido nro:"+nroPedido);
                } else {
                    System.out.println("Ya se creo el pedido");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }else{
            System.out.println("El pedido:"+nroPedido+" ya esta creado con el id: "+getIdPedido());
        }
    }
    
    
    public void cambiarEstado(String nroPedido,String estado){ //A:ANULADO,P=PENDIENTE,C:COBRADO
        String sSQL = "UPDATE pedido SET pedido.pedido_estado='"+estado+"' WHERE N_PEDIDO='"+n_pedido+"'";
        try {
            Statement st = conex.createStatement();
            int rowsAffected = st.executeUpdate(sSQL);
            if (rowsAffected > 0) {
                System.out.println("Se cambio el estado del registro de pedido nro:"+nroPedido+" a "+estado);
            } else {
                JOptionPane.showMessageDialog( null,"No se pudo realizar el cambio de estado del pedido");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void addCuadro(int idCuadro){
        String sSQL = "INSERT INTO vta_det(pedido,cuadro,cant) VALUES ("+idPedido+",'"+idCuadro+"',1)";
        JOptionPane.showMessageDialog(null,"NUM DE ID PEDIDO: "+idPedido);
        try {
            Statement st = conex.createStatement();
            int rowsAffected = st.executeUpdate(sSQL);
            if (rowsAffected > 0) {
                System.out.println("Se incerto el cuadro con id:"+idCuadro+" con id:"+idPedido+", al pedido:"+n_pedido);
            } else {
                JOptionPane.showMessageDialog( null,"ALGO MALO PASO,NO SE GENERO PEDIDO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cambiarCant(int id, int cant){
        String sSQL = "UPDATE vta_det SET vta_det.cant="+cant+" WHERE id_vta_det="+id;
        try {
            Statement st = conex.createStatement();
            int rowsAffected = st.executeUpdate(sSQL);
            if (rowsAffected > 0) {
                System.out.println("Se cambio la cantidad a "+cant+" del id:"+id);
            } else {
                JOptionPane.showMessageDialog( null,"No se pudo realizar el cambio de cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
}
