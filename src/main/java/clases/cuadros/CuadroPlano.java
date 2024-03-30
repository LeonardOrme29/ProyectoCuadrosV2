package clases.cuadros;
//import logic.Cuadro;

import clases.materiales.Liston;
import clases.materiales.Nordex;
import clases.materiales.Vidrio;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CuadroPlano extends Cuadro {
    private Vidrio vidrio;
    private Nordex nordex;
    private Connection conex;
    public CuadroPlano(double largo, double ancho,Liston li, Vidrio vidrio,Nordex nordex){
        super(largo,ancho,li);
        this.vidrio=vidrio;
        this.nordex=nordex;
        Conexion cone=new Conexion();
        conex=cone.conectar();

    }
    public double cuadroPlanoCosto(){
        System.out.println("Marco: "+li.precio_liston(tamCuadro()));
        System.out.println("Vidrio: "+tamArte()*vidrio.getPrecio_costo_cm2());
        System.out.println("Nordex: "+tamArte()*nordex.getPrecio_costo_cm2());
        return li.precio_liston(tamCuadro())+(tamArte()*vidrio.getPrecio_costo_cm2())+(tamArte()*nordex.getPrecio_costo_cm2());//+cotsoAdicionales()
    }
    public static void main(String[] args) {
        Liston li=new Liston(320, 12.50, 1.5);
        Vidrio vi=new Vidrio(0.008);
        Nordex no=new Nordex(240,122,31);
        CuadroPlano cp1=new CuadroPlano(21, 27.9, li, vi, no);
        System.out.println(cp1.cuadroPlanoCosto());
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