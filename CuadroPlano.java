public class CuadroPlano extends Cuadro {
    private Vidrio vidrio;
    private Nordex nordex;
    private Clavos clavo;
    public CuadroPlano(double largo, double ancho, Vidrio vidrio,Nordex nordex,Clavos clavo){
        super(largo,ancho);
        this.vidrio=vidrio;
        this.nordex=nordex;
        this.clavo=clavo;
    }
}