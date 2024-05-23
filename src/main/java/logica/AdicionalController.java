/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import alertasVistas.AdicionalAdd;
import clases.materiales.Adicional;
import java.awt.Component;
import java.awt.HeadlessException;
import java.util.ArrayList;
/**
 *
 * @author leonardo.ormeno
 */
public class AdicionalController {
    protected ArrayList<Adicional> adicionales;
    public AdicionalController(){
        ArrayList<Adicional> adi=new ArrayList();
        adicionales=adi;
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
    
    
}
