/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import clases.cuadros.*;
import clases.materiales.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *
 * @author leonardo.ormeno
 */
public class CuadroController {

    private double largo;
    private double ancho;
    private String tipoCuadro;
    private int idListon;
    private String frontal;
    private String trasera;
    private String varilla;
    private Connection conex;

    private int id_frontal;
    private int id_trasera;
    private int id_varilla;

    protected String precioCuadro;
    protected int idCuadro;

    public CuadroController(Connection conex, double largo, double ancho, String tipoCuadro, int idListon, String frontal, String trasera, String varilla) {
        this.conex = conex;
        this.largo = largo;
        this.ancho = ancho;
        this.idListon = idListon;
        this.tipoCuadro = tipoCuadro;
        this.frontal = frontal;
        this.trasera = trasera;
        this.varilla = varilla;
    }

    public Liston datosListon(int liston) {
        //LISTON
        Liston li = new Liston();
        try {
            System.out.println("liston");
            String sSQL = "SELECT largo,costo,prof,pre_marco FROM liston WHERE id='" + liston + "'";
            Statement cn = conex.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            while (res.next()) {
                li.setLargo(Double.parseDouble(res.getString("largo")));
                li.setPrecio_costo(Double.parseDouble(res.getString("costo")));
                li.setProfundidad(Double.parseDouble(res.getString("prof")));
                li.setMarco_tam_cm(Double.parseDouble(res.getString("pre_marco")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return li;
    }

    public Vidrio datosFrontal(String frontal) {
        Vidrio fr1 = new Vidrio();
        if (frontal == null) {
            id_frontal = 0;
        }
        //FRONTAL
        try {
            System.out.println("frontal");
            String sSQL = "SELECT id,costocm2 FROM frontal WHERE des='" + frontal + "'";
            Statement cn = conex.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            if(res.next()){
                id_frontal = Integer.parseInt(res.getString("id"));
                fr1.setPrecio_costo_cm2(Double.parseDouble(res.getString("costocm2")));
            }else{
                id_frontal=0;
                fr1.setPrecio_costo_cm2(0);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return fr1;
    }

    public Nordex datosTrasera(String trasera) {
        Nordex tr1 = new Nordex();
        if (trasera == null) {
            id_trasera = 0;
        }
        try {
            System.out.println("trasera");
            String sSQL = "SELECT id,costocm2 FROM trasera WHERE des='" + trasera + "'";
            Statement cn = conex.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            if(res.next()){
                id_trasera = Integer.parseInt(res.getString("id"));
                tr1.setPrecio_costo_cm2(Double.parseDouble(res.getString("costocm2")));
            }else{
                id_trasera=0;
                tr1.setPrecio_costo_cm2(0);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tr1;
    }

    public Varilla datosVarilla(String varilla) {
        Varilla va1 = new Varilla();
        try {
            System.out.println("varilla");
            String sSQL = "SELECT id,costo,largo,prof FROM varilla WHERE des='" + varilla + "'";
            Statement cn = conex.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            if (res.next()) {
                // Si se encuentra un registro, asignar valores a va1 y id_varilla
                id_varilla = Integer.parseInt(res.getString("id"));
                va1.setPrecio_costo(Double.parseDouble(res.getString("costo")));
                va1.setLargo(Double.parseDouble(res.getString("largo")));
                va1.setProfundidad(Double.parseDouble(res.getString("prof")));
            } else {
                id_varilla = 0;
                va1.setPrecio_costo(0);
                va1.setLargo(0);
                va1.setProfundidad(0);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("LISTON INFO CONTROLLER");
        System.out.println(va1.getLargo());
        System.out.println(va1.getProfundidad());
        System.out.println(va1.precio_costo());
        return va1;
    }
    public int obtenerIdCuadroProximo(){
        try{
            String sSQL="SELECT id_cuadro FROM cuadro WHERE id_cuadro=(SELECT MAX(id_cuadro) FROM cuadro)"; 
            Statement cn=conex.createStatement();
            ResultSet res=cn.executeQuery(sSQL);
            return res.getInt("id_cuadro");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Error al realizar la funcion: obtenerIdCuadroProximo()", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    public void grabarCuadro() {
        try {
            // Definir el procedimiento almacenado
            String procedimiento = "{ CALL cuadro_grabarCuadro(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            try (CallableStatement cs = conex.prepareCall(procedimiento)) {
                // Establecer los parámetros de entrada
                cs.setDouble(1, largo);
                cs.setDouble(2, ancho);
                cs.setString(3, tipoCuadro);
                cs.setInt(4, idListon);
                cs.setInt(5, id_frontal);
                cs.setInt(6, id_trasera);
                cs.setInt(7, id_varilla);
                cs.setString(8, precioCuadro);

                // Registrar el parámetro de salida
                cs.registerOutParameter(9, java.sql.Types.INTEGER);

                // Ejecutar el procedimiento
                cs.execute();

                // Obtener el ID generado
                idCuadro = cs.getInt(9);
                JOptionPane.showMessageDialog(null, "El cuadro se guardó correctamente con el ID: " + idCuadro);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la inserción: " + e.getMessage());
        }
        /*String sSQL = "INSERT INTO cuadro (largo, ancho, tipo, liston, frontal, trasera, varilla, precio, custom, pedido_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'S', 'P')";
        try {
            // Preparar la sentencia SQL con la opción de obtener las claves generadas
            PreparedStatement pst = conex.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, largo);
            pst.setDouble(2, ancho);
            pst.setString(3, tipoCuadro);
            pst.setInt(4, idListon);
            // Si id_frontal es 0, establecer el valor como NULL en la base de datos
            if (id_frontal == 0) {
                pst.setNull(5, java.sql.Types.INTEGER);
            } else {
                pst.setInt(5, id_frontal);
            }
            // Si id_trasera es 0, establecer el valor como NULL en la base de datos
            if (id_trasera == 0) {
                pst.setNull(6, java.sql.Types.INTEGER);
            } else {
                pst.setInt(6, id_trasera);
            }
            // Si id_varilla es 0, establecer el valor como NULL en la base de datos
            if (id_varilla == 0) {
                pst.setNull(7, java.sql.Types.INTEGER);
            } else {
                pst.setInt(7, id_varilla);
            }
            pst.setString(8, precioCuadro);
            // Ejecutar la inserción
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                // Si se insertó correctamente, obtener el ID generado
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    idCuadro = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "El cuadro se guardó correctamente con el ID: " + idCuadro);
                }
            } else {
                System.out.println("No se pudo realizar el registro");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la inserción: " + e.getMessage());
        }*/
    }

    //MENU - CALCULAR PRECIO // TAMBIEN MANDA A GRABAR A BD
    public void precio_costo_cuadro() {
        Liston l1 = datosListon(idListon);
        Vidrio f1 = datosFrontal(frontal);
        Nordex t1 = datosTrasera(trasera);
        Varilla v1 = datosVarilla(varilla);
        if (tipoCuadro.equals("PLANO")) {
            CuadroPlano cp1 = new CuadroPlano(largo, ancho, l1, f1, t1, v1);
            setPrecioCuadro(cp1.cuadroPlanoCosto());
        } else if (tipoCuadro.equals("BOX")) {
            CuadroBox cb1 = new CuadroBox(largo, ancho, l1, f1, t1, v1);
            setPrecioCuadro(cb1.cuadroBoxCosto());
        } else if (tipoCuadro.equals("DOBLE MARCO")) {
            CuadroDobleM dm1 = new CuadroDobleM(largo, ancho, l1, f1, t1, v1);
            setPrecioCuadro(dm1.cuadroDobleMCosto());
        } else if (tipoCuadro.equals("DOBLE VIDRIO")) {
            CuadroDobleV dv1 = new CuadroDobleV(largo, ancho, l1, f1, t1, v1);
            setPrecioCuadro(dv1.cuadroDobleVCosto());
        } else if (tipoCuadro.equals("ENMARCADO")) {
            CuadroEnmarcado ce1 = new CuadroEnmarcado(largo, ancho, l1, f1, t1, v1);
            setPrecioCuadro(ce1.cuadroEnmarcadoCosto());
        } else {
            System.out.println("ERROR EN COTIZACION CUADROS");
        }

    }
    
    public void cuadro_adi_insert(){
        String sSQL="{ CALL cuadro_adi_insert(?) }";
        try (CallableStatement cs = conex.prepareCall(sSQL)){
            // Establecer el parámetro de entrada del procedimiento
            cs.setInt(1,idCuadro);
            // Ejecutar el procedimiento
            cs.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //Setters
    public void setPrecioCuadro(double precioCuadro) {
        DecimalFormat formato = new DecimalFormat("#.##");
        String numeroFormateado = formato.format(precioCuadro);
        this.precioCuadro = numeroFormateado;
    }

    //Getters
    public String getPrecioCuadro() {
        return precioCuadro;
    }

    public int getIdCuadro() {
        return idCuadro;
    }

}
