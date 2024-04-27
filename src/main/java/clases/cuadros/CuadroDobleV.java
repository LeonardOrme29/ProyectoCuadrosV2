/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.cuadros;

import clases.materiales.*;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.ormeno
 */
public class CuadroDobleV extends Cuadro{
    private Vidrio vi;
    private Nordex n1;
    private Varilla va;
    private Connection conex;

    public CuadroDobleV(double largo,double ancho,Liston li,Vidrio vi,Nordex n1,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.va=va;
        this.n1=n1;
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public double cuadroDobleVCosto(){
        double c_liston=li.precio_liston(tamCuadro()); 
        System.out.println("Marco: "+c_liston);
        double costoFrontal=0,costoTrasera=0,costoVarilla=0;
        if(vi.getPrecio_costo_cm2()>0){
            costoFrontal=tamArte()*vi.getPrecio_costo_cm2();
            System.out.println("Frontal: "+costoFrontal);
        }
        else{System.out.println("Sin Frontal");}
        if(n1.getPrecio_costo_cm2()>0){
            costoTrasera=tamArte()*n1.getPrecio_costo_cm2();
            System.out.println("Trasera: "+costoTrasera);
        }
        else{System.out.println("Sin Trasera");}
        if(va.getLargo()>0){
            costoVarilla=va.precio_varilla_costo(getLargo(),getAncho());
            System.out.println("Varilla: "+costoVarilla);
        }
        else{System.out.println("Sin Varilla");}
        return c_liston+costoFrontal+costoTrasera+costoVarilla;
    }
        /*
    public void grabarCuadro(double largo, double ancho,String tipo,int liston,int frontal,int trasera,int varilla,double precio){
        System.out.println(largo);
        System.out.println(ancho);
        String sSQL = "INSERT INTO cuadro (largo, ancho, tipo, liston, frontal, trasera,varilla, precio,custom,pedido_estado) VALUES ("+largo+","+ancho+",'"+tipo+"',"+liston+","+frontal+","+trasera+","+varilla+","+precio+",'S','P')";
        try {
            Statement st = conex.createStatement();
            int rowsAffected = st.executeUpdate(sSQL);
            if (rowsAffected > 0) {
                System.out.println("El cuadro se guardo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el registro");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    */
}
