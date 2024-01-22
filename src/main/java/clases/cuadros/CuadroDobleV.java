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
public class CuadroDobleV extends Cuadro{
    private Vidrio vi;
    private Varilla va;
    public CuadroDobleV(double largo,double ancho,Liston li,Vidrio vi,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.va=va;
    }
    public double cuadroDobleVCosto(){
        double c_liston=li.precio_liston(tamCuadro());
        double c_vidrio=tamArte()*vi.getPrecio_costo_cm2();
        double c_varilla=va.precio_varilla_costo(getLargo(),getAncho());
        double adicionales=0;
        System.out.println("Marco: "+c_liston);
        System.out.println("Vidrio unidad: "+c_vidrio+" -> x2 ("+c_vidrio*2+")");
        System.out.println("Varilla: "+c_varilla+" -> x2 ("+c_varilla*2+")");
        return c_liston+c_vidrio*2+c_varilla*2+adicionales;
    }
    public static void main(String arg[]){
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        Vidrio vi=new Vidrio(0.008);
        Varilla va=new Varilla(320, 5, 2.5);
        CuadroDobleV cdv=new CuadroDobleV(40,45,li,vi,va);
        System.out.println(cdv.cuadroDobleVCosto());
    }
}
