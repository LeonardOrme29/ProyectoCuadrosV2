package clases.materiales;

public class Varilla {
    private double largo; 
    private double precio_costo;
    private double profundidad;
    public Varilla(double largo,double precio_costo,double profundidad){
        this.largo=largo;
        this.precio_costo=precio_costo;
        this.profundidad=profundidad;
    }
    //GETTERS
    public double getLargo(){
        return this.largo;
    }
    public double precio_costo(){
        return this.precio_costo;
    }
    public double getProfundidad(){
        return this.profundidad;
    }
    //METODOS
    public double precio_costo_cm(){
        return this.precio_costo/this.largo;
    }
    public double cantVarilla(double largo,double ancho){ //METODO PARA HALLAR LA CANTIDAD DE VARILLA QUE SE NECESITA DE ACUERDO AL ARTE.
        return (largo+2)*2+(ancho+2)*2;
    }
    public double precio_varilla_costo(double largo,double ancho){
        return cantVarilla(largo,ancho)*precio_costo_cm();
    }
}
