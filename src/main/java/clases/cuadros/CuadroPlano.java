package clases.cuadros;
//import logic.Cuadro;

import clases.materiales.*;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CuadroPlano extends Cuadro {
    private Vidrio vidrio;
    private Nordex nordex;
    private Varilla varilla;
    private Connection conex;
    public CuadroPlano(double largo, double ancho,Liston li, Vidrio vidrio,Nordex nordex,Varilla varilla){
        super(largo,ancho,li);
        this.vidrio=vidrio;
        this.nordex=nordex;
        this.varilla=varilla;
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public double cuadroPlanoCosto(){
        double c_liston=li.precio_liston(tamCuadro()); 
        System.out.println("Marco: "+c_liston);
        double costoFrontal=0,costoTrasera=0,costoVarilla=0;
        if(vidrio.getPrecio_costo_cm2()>0){
            costoFrontal=tamArte()*vidrio.getPrecio_costo_cm2();
            System.out.println("Frontal: "+costoFrontal);
        }
        else{System.out.println("Sin Frontal");}
        if(nordex.getPrecio_costo_cm2()>0){
            costoTrasera=tamArte()*nordex.getPrecio_costo_cm2();
            System.out.println("Trasera: "+costoTrasera);
        }
        else{System.out.println("Sin Trasera");}
        if(varilla.getLargo()>0){
            costoVarilla=varilla.precio_varilla_costo(getLargo(),getAncho());
            System.out.println("Varilla: "+costoVarilla);
        }
        else{System.out.println("Sin Varilla");}
        return c_liston+costoFrontal+costoTrasera+costoVarilla;//+cotsoAdicionales()
    }
    /*
    public void grabarCuadro(double largo, double ancho,String tipo,int liston,int frontal,int trasera,double precio,String desc){
        System.out.println(largo);
        System.out.println(ancho);
        String sSQL = "INSERT INTO cuadro (largo, ancho, tipo, liston, frontal, trasera, precio,custom,pedido_estado,des) VALUES ("+largo+","+ancho+",'"+tipo+"',"+liston+","+frontal+","+trasera+","+precio+",'S','P',"+desc+")";
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