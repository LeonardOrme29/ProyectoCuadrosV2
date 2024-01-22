package clases.cuadros;
//import logic.Cuadro;

import clases.materiales.Liston;
import clases.materiales.Nordex;
import clases.materiales.Vidrio;
import clases.materiales.Varilla;


public class CuadroBox extends Cuadro {
    private Vidrio vi;
    private Nordex no;
    private Varilla va;
    public CuadroBox(double largo,double ancho,Liston li,Vidrio vi,Nordex no,Varilla va){
        super(largo,ancho,li);
        this.vi=vi;
        this.no=no;
        this.va=va;
    }
    public double cuadroBoxCosto(){
        System.out.println("Marco: "+li.precio_liston(tamCuadro()));
        System.out.println("Vidrio: "+tamArte()*vi.getPrecio_costo_cm2());
        System.out.println("Nordex: "+tamArte()*no.getPrecio_costo_cm2());
        System.out.println("Varilla: "+va.precio_varilla_costo(getLargo(),getAncho()));
        return li.precio_liston(tamCuadro())+(tamArte()*vi.getPrecio_costo_cm2())+(tamArte()*no.getPrecio_costo_cm2())+(va.precio_varilla_costo(getLargo(),getAncho()));
    }
    public static void main(String[] args) {
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        Vidrio vi=new Vidrio(0.008);
        Nordex no=new Nordex(240,122,31);
        Varilla va=new Varilla(320, 5, 2.5);
        CuadroBox cp1=new CuadroBox(21, 27.9, li, vi, no,va);
        System.out.println(cp1.cuadroBoxCosto());
    }
}