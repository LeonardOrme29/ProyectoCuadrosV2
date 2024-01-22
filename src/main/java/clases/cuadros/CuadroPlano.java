package clases.cuadros;
//import logic.Cuadro;

import clases.materiales.Liston;
import clases.materiales.Nordex;
import clases.materiales.Vidrio;


public class CuadroPlano extends Cuadro {
    private Vidrio vidrio;
    private Nordex nordex;
    public CuadroPlano(double largo, double ancho,Liston li, Vidrio vidrio,Nordex nordex){
        super(largo,ancho,li);
        this.vidrio=vidrio;
        this.nordex=nordex;
    }
    public double cuadroPlanoCosto(){
        System.out.println("Marco: "+li.precio_liston(tamCuadro()));
        System.out.println("Vidrio: "+tamArte()*vidrio.getPrecio_costo_cm2());
        System.out.println("Nordex: "+tamArte()*nordex.getPrecio_costo_cm2());
        return li.precio_liston(tamCuadro())+(tamArte()*vidrio.getPrecio_costo_cm2())+(tamArte()*nordex.getPrecio_costo_cm2());//+cotsoAdicionales()
    }
    public static void main(String[] args) {
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        Vidrio vi=new Vidrio(0.008);
        Nordex no=new Nordex(240,122,31);
        CuadroPlano cp1=new CuadroPlano(21, 27.9, li, vi, no);
        System.out.println(cp1.cuadroPlanoCosto());
    }
}