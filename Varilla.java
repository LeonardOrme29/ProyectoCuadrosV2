public class Varilla {
    private float largo; 
    private double precio_costo;
    private float profundidad;
    public Varilla(float largo,double precio_costo,float profundidad){
        this.largo=largo;
        this.precio_costo=precio_costo;
        this.profundidad=profundidad;
    }
    //GETTERS
    public float getLargo(){
        return this.largo;
    }
    public double precio_costo(){
        return this.precio_costo;
    }
    public float getProfundidad(){
        return this.profundidad;
    }
    //METODOS
    public double precio_costo_cm(){
        return this.precio_costo/this.largo;
    }
    
}
