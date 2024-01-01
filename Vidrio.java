public class Vidrio {
    private double precio_costo_cm2;
    public Vidrio(double precio_costo_cm2){
        this.precio_costo_cm2=precio_costo_cm2;
    }
    public Vidrio(float largo, float ancho,double precio_costo){
        setPrecio_costo_cm2(calc_precio_costo_cm2(largo,ancho,precio_costo));
    }
    //SETTERS
    public void setPrecio_costo_cm2(double precio_costo_cm2){
        this.precio_costo_cm2=precio_costo_cm2;
    }
    //GETTERS
    public double getPrecio_costo_cm2(){
        return this.precio_costo_cm2;
    }
    //METODOS
    public double calc_precio_costo_cm2(float largo, float ancho,double precio_costo){
        return precio_costo/(largo*ancho);
    }
}
