/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leonardo.ormeno
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prueba_cuadros";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection con=null;
    public Conexion(){
        //conectar();
    }

    public Connection conectar(){
        try{
            con=DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.err.println("SE CONECTO");
        }catch(Exception e){
            System.out.println("ERROR AL CONECTAR"+" "+e);
        }
        return con;
    }

}

