/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.cuadros;

import clases.materiales.*;

/**
 *
 * @author leonardo.ormeno
 */
public class CuadroDobleM extends Cuadro{
    private Vidrio vi;
    private Nordex no;
    private Varilla va;
    public CuadroDobleM(double largo,double ancho,Liston li,Vidrio vi,Nordex no,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.no=no;
        this.va=va;
    }
    public double cuadroDobleMCosto(){
        double c_liston=li.precio_liston(tamCuadro());  //COSTO DE MARCO 1
        double c_liston2=li.precio_liston(tamCuadro()+(li.getMarco_tam_cm()*2.5));      //COSTO DE MARCO 2
        double c_vidrio=tamArte()*vi.getPrecio_costo_cm2();     //COSTO DEL VIDRIO
        double c_varilla=va.precio_varilla_costo(getLargo(),getAncho());        //COSTO VARILLA
        double c_nordex=tamArte()*no.getPrecio_costo_cm2();     //COSTO NORDEX
        double adicionales=0;
        System.out.println("Marco 1: "+c_liston);
        System.out.println("Marco 2: "+c_liston2);
        System.out.println("Vidrio unidad: "+c_vidrio);
        System.out.println("Varilla: "+c_varilla+" -> x2 ("+c_varilla*2+")");
        System.out.println("Nordex: "+c_nordex);
        return c_liston+c_liston2+c_vidrio+c_varilla+c_nordex;
    }
    public static void main(String args[]){
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        Vidrio vi=new Vidrio(0.008);
        Nordex no=new Nordex(240,122,31);
        Varilla va=new Varilla(320, 5, 2.5);
        CuadroDobleM cdm=new CuadroDobleM(40,45,li,vi,no,va);
        System.out.println(cdm.cuadroDobleMCosto());
    }
}
