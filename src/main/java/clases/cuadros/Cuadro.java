package clases.cuadros;

import clases.materiales.Clavo;
import clases.materiales.Liston;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Cuadro {
    private String tipoC;
    protected double largo;
    protected double ancho;
    private float profundidad;
    protected Liston li;
    protected Clavo clavo;
    public Cuadro(double largo,double ancho,Liston li){
        this.largo=largo;
        this.ancho=ancho;
        this.li=li;
    }
    // SETTERS
    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }
    public void setListon(Liston li) {
        this.li = li;
    }
    public void setClavo(Clavo clavo){
        this.clavo=clavo;
    }
    // GETTERS
    public String getTipoC() {
        return tipoC;
    }
    public double getLargo() {
        return largo;
    }
    public double getAncho() {
        return ancho;
    }
    public float getProfundidad() {
        return profundidad;
    }
    public Liston getListon() {
        return li;
    }
    public Clavo getClavo() {
        return clavo;
    }
    //METODOS
    public double tamArte(){
        return largo*ancho;
    }
    public double tamCuadro(){
        return (largo*2)+(ancho*2)+(li.getMarco_tam_cm()*2);
    }
    public int cantMadera(){
        double tam_liston=li.getLargo();
        double tamTotal_cuadro=tamCuadro();
        int cont=1;
        while(tamTotal_cuadro/tam_liston>1){
            cont+=1;
            tamTotal_cuadro=tamTotal_cuadro-tam_liston;
        } 
        return cont;
    }
    public double costoAdicionales(){//adiccionales pintura, cinta, etc.
        return (clavo.getCostoUnitario()*8)+2;
    }
    
    public int grabarCuadro(Connection conex, double largo, double ancho, String tipo, int liston, int frontal, int trasera, int varilla, double precio) {
        int idCuadro=-1;
        String sSQL = "INSERT INTO cuadro (largo, ancho, tipo, liston, frontal, trasera, varilla, precio, custom, pedido_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'S', 'P')";
        
        try {
            // Preparar la sentencia SQL con la opción de obtener las claves generadas
            PreparedStatement pst = conex.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, largo);
            pst.setDouble(2, ancho);
            pst.setString(3, tipo);
            pst.setInt(4, liston);
            pst.setInt(5, frontal);
            pst.setInt(6, trasera);
            pst.setInt(7, varilla);
            pst.setDouble(8, precio);
            
            // Ejecutar la inserción
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Si se insertó correctamente, obtener el ID generado
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    idCuadro = rs.getInt(1);
                    JOptionPane.showMessageDialog(null,"El cuadro se guardó correctamente con el ID: " + idCuadro);
                }
            } else {
                System.out.println("No se pudo realizar el registro");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la inserción: " + e.getMessage());
        }
        return idCuadro;
    }
    
    public int grabarCuadro(Connection conex, double largo, double ancho, String tipo, int liston, int frontal, int trasera, double precio) {
        int idCuadro=-1;
        String sSQL = "INSERT INTO cuadro (largo, ancho, tipo, liston, frontal, trasera, precio, custom, pedido_estado) VALUES (?, ?, ?, ?, ?, ?, ?, 'S', 'P')";
        
        try {
            // Preparar la sentencia SQL con la opción de obtener las claves generadas
            PreparedStatement pst = conex.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, largo);
            pst.setDouble(2, ancho);
            pst.setString(3, tipo);
            pst.setInt(4, liston);
            pst.setInt(5, frontal);
            pst.setInt(6, trasera);
            pst.setDouble(7, precio);
            
            // Ejecutar la inserción
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Si se insertó correctamente, obtener el ID generado
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    idCuadro = rs.getInt(1);
                    JOptionPane.showMessageDialog(null,"El cuadro se guardó correctamente con el ID: " + idCuadro);
                }
            } else {
                System.out.println("No se pudo realizar el registro");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la inserción: " + e.getMessage());
        }
        return idCuadro;
    }
    //Main
    public static void main(String[] args) {
        Liston li=new Liston(320, 12.50, 1.5);
        Cuadro c1=new Cuadro(21,29.7,li);
        //System.out.println(c1.tamCuadro());
        System.out.println(c1.cantMadera());
        System.out.println(li.precio_liston(c1.tamCuadro()));
        //System.out.println(c1.descCuadro("PLANO","ACRILICO","NORDEX"));
    }
}
