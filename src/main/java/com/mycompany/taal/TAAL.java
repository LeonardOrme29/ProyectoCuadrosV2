/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taal;
import clases.materiales.Liston;

/**
 *
 * @author leonardo.ormeno
 */
public class TAAL {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Liston li=new Liston(320, 12.50, 1.5, 2.5);
        System.out.println(li.precio_costo_cm());
    }
}