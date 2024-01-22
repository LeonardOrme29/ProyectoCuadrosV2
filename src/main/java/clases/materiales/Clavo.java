package clases.materiales;

public class Clavo {
    private double costoUnitario;
    private float size;
    public Clavo(double costoUnitario,float size){
        this.costoUnitario=costoUnitario;
        this.size=size;
    }
    public double getCostoUnitario(){
        return costoUnitario;
    }
}
