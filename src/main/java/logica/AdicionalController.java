/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import alertasVistas.AdicionalAdd;
import clases.materiales.Adicional;
import conexion.Conexion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
/**
 *
 * @author leonardo.ormeno
 */
public class AdicionalController {
    protected ArrayList<Adicional> adicionales;
    private Connection conex;
    public AdicionalController(){
        ArrayList<Adicional> adi=new ArrayList();
        adicionales=adi;
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public ArrayList<Adicional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(ArrayList<Adicional> adicionales) {
        this.adicionales = adicionales;
    }
    
    //METODOS
    public void arrayAdicional(Component ventana){
        try{
            adicionales.add(addAdicional(ventana));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public Adicional addAdicional(Component ventana){
        try{
            AdicionalAdd adicionalAdd=new AdicionalAdd(new javax.swing.JFrame(), true);
            adicionalAdd.setLocationRelativeTo(ventana);
            adicionalAdd.setVisible(true);
            System.out.println("Se adiciono el adicional la desc: "+adicionalAdd.getAdi().getDes_corta());
            return adicionalAdd.getAdi();
        }catch(HeadlessException e){
            System.out.println(e);
        }
        return null;
    }
    //GRABAR ADICIONALES EN LA BD
    public int grabarAdi_box_det(int id_adicional, int cant){
        String sSQL="{ CALL adi_det_crear(?, ?, ?) }";
        try (CallableStatement cs = conex.prepareCall(sSQL)){
            // Establecer el parámetro de entrada del procedimiento
            cs.setInt(1,id_adicional);
            cs.setInt(2,cant);
            cs.registerOutParameter(3, Types.INTEGER);
            // Ejecutar el procedimiento
            cs.execute();
            return cs.getInt(3);
        }catch(SQLException e){
            System.out.println(e);
        }
        return -1;
    }
    
    //VINCULAR EL CUADRO CON LOS ADICIONALES EN BD
    public int adi_box_insertarCuadro(int id_adi_box_det, int id_cuadro){
        String sSQL="{ CALL adi_box_insertarCuadro(?, ?) }";
        try (CallableStatement cs = conex.prepareCall(sSQL)){
            // Establecer el parámetro de entrada del procedimiento
            cs.setInt(1,id_adi_box_det);
            cs.setInt(2,id_cuadro);
            // Ejecutar el procedimiento
            cs.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
        return -1;
    }
}
