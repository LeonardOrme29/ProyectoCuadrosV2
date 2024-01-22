package clases.cuadros;

import clases.materiales.Clavo;
import clases.materiales.Liston;

public class Cuadro {
    private String tipoC;
    private double largo;
    private double ancho;
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
    //Main
    public static void main(String[] args) {
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        Cuadro c1=new Cuadro(21,29.7,li);
        //System.out.println(c1.tamCuadro());
        System.out.println(c1.cantMadera());
        System.out.println(li.precio_liston(c1.tamCuadro()));
    }
}
