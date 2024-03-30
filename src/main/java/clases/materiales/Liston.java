package clases.materiales;

public class Liston {
    private double largo;
    private double precio_costo;
    private double marco_tam_cm;
    private double profundidad;
    public Liston(double largo, double precio_costo, double marco_tam_cm){
        this.largo=largo;
        this.precio_costo=precio_costo;
        this.marco_tam_cm=marco_tam_cm;
    }
    //GETTERS
    public double getLargo(){
        return this.largo;
    }
    public double getPrecio_costo(){
        return this.precio_costo;
    }
    public double getMarco_tam_cm(){
        return this.marco_tam_cm;
    }
    public double getProfundidad(){
        return this.profundidad;
    }
    //METODOS
    public double precio_costo_cm(){
        return this.precio_costo/this.largo;
    }
    public double precio_liston(double tamCuadro){
        return tamCuadro*precio_costo_cm();
    }
}
