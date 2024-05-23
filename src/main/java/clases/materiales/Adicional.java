/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.materiales;

/**
 *
 * @author leonardo.ormeno
 */
public class Adicional {
    protected int id;
    protected String des;
    protected String des_corta;
    protected String categoria;
    protected String tipo_metrica;
    protected double precio_costo_unidad;
    protected int cant_paquete;
    protected float precio_venta_total;
    protected int cant;

    public Adicional(String des, String des_corta, String categoria, String tipo_metrica, double precio_costo_unidad, int cant_paquete, float precio_venta_total) {
        this.des = des;
        this.des_corta = des_corta;
        this.categoria = categoria;
        this.tipo_metrica = tipo_metrica;
        this.precio_costo_unidad = precio_costo_unidad;
        this.cant_paquete = cant_paquete;
        this.precio_venta_total = precio_venta_total;
    }

    public Adicional(int id, String des, String des_corta, String categoria, String tipo_metrica, double precio_costo_unidad, int cant_paquete, float precio_venta_total,int cant) {
        this.id = id;
        this.des = des;
        this.des_corta = des_corta;
        this.categoria = categoria;
        this.tipo_metrica = tipo_metrica;
        this.precio_costo_unidad = precio_costo_unidad;
        this.cant_paquete = cant_paquete;
        this.precio_venta_total = precio_venta_total;
        this.cant=cant;
    }
    
    public Adicional() {
    }

    public int getId() {
        return id;
    }

    public String getDes_corta() {
        return des_corta;
    }

    public int getCant() {
        return cant;
    }

    public float getPrecio_venta_total() {
        return precio_venta_total;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    
    
    
    
}
