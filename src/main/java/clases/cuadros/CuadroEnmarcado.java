/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.cuadros;

import clases.materiales.*;
import conexion.Conexion;
import java.sql.Connection;

/**
 *
 * @author leonardo.ormeno
 */
public class CuadroEnmarcado extends Cuadro{
    private Vidrio vi;
    private Nordex no;
    private Varilla va;
    private Connection conex;
    public CuadroEnmarcado(double largo,double ancho,Liston li,Vidrio vi,Nordex no,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.no=no;
        this.va=va;
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public double cuadroEnmarcadoCosto(){
        double c_liston=li.precio_liston(tamCuadro()); 
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
        return c_liston+costoFrontal+costoTrasera+costoVarilla;
    }
}
