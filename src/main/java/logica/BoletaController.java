/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.ormeno
 */
public class BoletaController {
    private String correlativo;
    private String numBoleta;
    private Connection conex;
    
    public BoletaController(Connection conex){
        this.conex=conex;
        numBoleta=obtenerNumBoleta();
        correlativo=obtenerCorrelativo();
    }
    public String getCorrelativo() {
        return correlativo;
    }

    public String getNumBoleta() {
        return numBoleta;
    }
    
    public String obtenerNumBoleta(){
        int numAux=-1;
        String numBoleta="Error";
        try{
            String sSQL="SELECT num_bol FROM vta_cab WHERE vta_cab.id_vta_cab=(SELECT MAX(id_vta_cab) FROM vta_cab)";
            Statement cn=conex.createStatement();
            ResultSet res=cn.executeQuery(sSQL);
            while (res.next()){
                numAux=res.getInt("num_bol");
            }
            numAux+=1;
            numBoleta = String.format("%06d", numAux);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Error al obtener numero de boleta", JOptionPane.ERROR_MESSAGE);
        }
        return numBoleta;
    }
    public String obtenerCorrelativo(){
        String corr="Error";
        try{
            String sSQL="SELECT corr_bol FROM taal_info";
            Statement cn=conex.createStatement();
            ResultSet res=cn.executeQuery(sSQL);
            while(res.next()){
                corr=res.getString("corr_bol");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Error al obtener numero de correlativo", JOptionPane.ERROR_MESSAGE);
        }
        return corr;
    }
    public static void main(String[] args) {
        
    }
    
}
