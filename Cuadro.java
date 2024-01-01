public class Cuadro {
    private String tipoC;
    private double largo;
    private double ancho;
    private float profundidad;
    private Liston li;
    public Cuadro(double largo,double ancho){
        this.largo=largo;
        this.ancho=ancho;
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
    //METODOS
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
    public double precio_liston(){
        return tamCuadro()*li.precio_costo_cm();
    }
    //Main
    public static void main(String[] args) {
        Cuadro c1=new Cuadro(21,29.7);
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        c1.setListon(li);
        //System.out.println(c1.tamCuadro());
        System.out.println(c1.cantMadera());
        System.out.println(c1.precio_liston());
    }
}
