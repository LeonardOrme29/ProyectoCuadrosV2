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
public class CuadroDobleM extends Cuadro{
    private Vidrio vi;
    private Nordex no;
    private Varilla va;
    private Connection conex;
    public CuadroDobleM(double largo,double ancho,Liston li,Vidrio vi,Nordex no,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.no=no;
        this.va=va;
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public double cuadroDobleMCosto(){
        double c_liston=li.precio_liston(tamCuadro());  //COSTO DE MARCO 1
        double c_liston2=li.precio_liston(tamCuadro()+(li.getMarco_tam_cm()*2.5));      //COSTO DE MARCO 2
        System.out.println("Marco: "+c_liston);
        double costoFrontal=0,costoTrasera=0,costoVarilla=0;
        if(vi.getPrecio_costo_cm2()>0){
            costoFrontal=tamArte()*vi.getPrecio_costo_cm2();
            System.out.println("Frontal: "+costoFrontal);
        }
        else{System.out.println("Sin Frontal");}
        if(no.getPrecio_costo_cm2()>0){
            costoTrasera=tamArte()*no.getPrecio_costo_cm2();
            System.out.println("Trasera: "+costoTrasera);
        }
        else{System.out.println("Sin Trasera");}
        if(va.getLargo()>0){
            costoVarilla=va.precio_varilla_costo(getLargo(),getAncho());
            System.out.println("Varilla: "+costoVarilla);
        }
        else{System.out.println("Sin Varilla");}
        return c_liston+c_liston2+costoFrontal+costoTrasera+costoVarilla;
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
    }*/
}
