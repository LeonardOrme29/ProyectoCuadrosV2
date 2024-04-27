/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.reportes;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.draw.LineSeparator;
import conexion.Conexion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo.ormeno
 */
public class ComandaPedido {
    private Connection conex;
    public ComandaPedido(){
        Conexion cone=new Conexion();
        conex=cone.conectar();
    }
    public void crearBoleta() throws FileNotFoundException{
        Rectangle pageSize = new Rectangle(200f, 400f); //ancho y alto
        Document doc = new Document(pageSize);
        doc.setMargins(10, 7, 10, 7);
        String destino="C:/cuadroventas/docs/prueba.pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(destino));
            doc.open();
            Phrase p=new Phrase("Hola mundo");
            imagenlogo(doc);
            infoEmpresa(doc);
            doc.add(new Paragraph(" "));//SALTO DE LINEA
            datosBoleta(doc);
            doc.add(new Paragraph(" "));//SALTO DE LINEA
            cabeceraPedido(doc);
            infoPedido(doc,12);
            total(doc);
            doc.add(p);
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void infoEmpresa(Document doc)throws DocumentException{
        try {
            Paragraph p = new Paragraph("TAAL CREATIONS & ART", new Font(FontFamily.COURIER, 10, Font.BOLD, new BaseColor(0, 0, 0)) );
            p.setAlignment(Element.ALIGN_CENTER);
            Paragraph p2 = new Paragraph("Correo Electrónico: atencion@cuadrostaal.com", new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)) );
            p2.setAlignment(Element.ALIGN_CENTER);
            Paragraph p3 = new Paragraph("Teléfono: 993474149", new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)) );
            p3.setAlignment(Element.ALIGN_CENTER);
            Paragraph p4 = new Paragraph("R.U.C. Nº 10288021", new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)) );
            p4.setAlignment(Element.ALIGN_CENTER);
            // Agregamos un párrafo con un texto y un tamaño de fuente personalizado
            doc.add(p);
            doc.add(p2);
            doc.add(p3);
            doc.add(p4);
        }catch (BadElementException ex) {
            Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void datosBoleta(Document doc)throws DocumentException{
        String co="B001";
        String num="000001";
        try {
            Paragraph p = new Paragraph("BOLETA DE VENTA ELECTRÓNICA", new Font(FontFamily.COURIER, 8, Font.BOLD, new BaseColor(0, 0, 0)) );
            p.setAlignment(Element.ALIGN_CENTER);
            Paragraph p2 = new Paragraph(co+"-"+num, new Font(FontFamily.COURIER, 8, Font.NORMAL, new BaseColor(0, 0, 0)) );
            p2.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(p2);
        }catch (BadElementException ex) {
            Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //CABECERA PEDIDO
    public void cabeceraPedido(Document doc)throws DocumentException{
        String formato = "%-5s %-26s %8s %8s";
        LineSeparator line = new LineSeparator();
        try {
            Paragraph p = new Paragraph(String.format(formato, "CANT", "DESCRIPCION", "P.UNIT","TOTAL"), new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)) );
            p.setSpacingAfter(3);
            doc.add(p);
            doc.add(line);
        }catch (BadElementException ex) {
            Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void infoPedido(Document doc,int id_vta_cab)throws DocumentException{
        try {
            String formato = "%-5s %-26s %8s %8s";
            String sql = "{CALL list_cuadros_vta_cab(?)}";
            CallableStatement cstmt = conex.prepareCall(sql);
            cstmt.setInt(1, 189);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String cantidad = rs.getString("cant");
                String descripcion = rs.getString("des_corta");
                String precioUnitario = rs.getString("precio_unitario");
                String total = rs.getString("pedido_precio");
                String filaFormateada = String.format(formato, cantidad, descripcion, precioUnitario, total);
                try {
                    Paragraph p = new Paragraph(filaFormateada, new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)));
                    //p.setAlignment(Element.ALIGN_RIGHT);
                    p.setSpacingAfter(6);
                    doc.add(p);
                } catch (BadElementException ex) {
                    Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void total(Document doc) throws DocumentException{
        int id_vta_cab=189;
        LineSeparator line = new LineSeparator();
        try{
            String sSQL="SELECT precio FROM vta_cab WHERE vta_cab.pedido="+id_vta_cab+"";
            PreparedStatement statement = conex.prepareStatement(sSQL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                float cantidad = res.getFloat("precio");
                String filaFormateada = String.format("%-3s", "Total: s/ " + String.format("%.2f", cantidad)+" ");
                try {
                    Paragraph p = new Paragraph(filaFormateada, new Font(FontFamily.COURIER, 6, Font.NORMAL, new BaseColor(0, 0, 0)));
                    p.setAlignment(Element.ALIGN_RIGHT);
                    doc.add(line);
                    doc.add(p);
                } catch (BadElementException ex) {
                    Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void imagenlogo(Document doc) throws DocumentException{
        try {
            Image imagen = Image.getInstance("C:/cuadroventas/image/logo.png");  //C:/cuadroventas/image/logo.png
                imagen.scaleAbsoluteWidth(50f);
                imagen.scaleAbsoluteHeight(50f);
                imagen.setAlignment(Image.ALIGN_CENTER);
                doc.add(imagen);
            } catch (BadElementException | IOException ex) {
                Logger.getLogger(ComandaPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void main(String args[]) throws FileNotFoundException{
        ComandaPedido cp1=new ComandaPedido();
        cp1.crearBoleta();
    }
}
