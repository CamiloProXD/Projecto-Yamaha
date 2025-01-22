/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Moto;
import Modelo.DaoMoto;
import Modelo.DaoUsuario;
import Modelo.DaoVenta;
import Modelo.DaoVentasMotos;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.VentasMotos;
import Vista.ViewRealizarVenta;
import Vista.ViewRegistrarpago;
import Vista.ViewCerrarSesionEmpleado;

import Modelo.Conexion;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRealizarVenta implements ActionListener {

    private ViewRegistrarpago vrp;
    private ViewRealizarVenta vrv;
    private ViewCerrarSesionEmpleado vcs;
    private DaoUsuario dUsuario;
    private Venta venta;
    private Moto moto;

    public CtlViewRealizarVenta(ViewRegistrarpago vrp, ViewRealizarVenta vrv, ViewCerrarSesionEmpleado vcs, DaoUsuario dUsuario) {
        this.vrp = vrp;
        this.vrv = vrv;
        this.vcs = vcs;
        this.dUsuario = dUsuario;

        vrv.btnAnadirMoto.addActionListener(this);
        vrv.btnGenerarFactura.addActionListener(this); 
        vrv.botonRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vrv.btnAnadirMoto)) {
            agregarCliente();
        }

        if (e.getSource().equals(vrv.btnGenerarFactura)) { 
            generarFactura(Integer.parseInt(vrv.txtIDVenta.getText()));
        }

        if (e.getSource().equals(vrv.botonRegresar)) {
            vcs.setVisible(true);
            vrv.dispose();
        }
    }

    private void agregarCliente() {
        Usuario nuevo = new Usuario(
                Integer.parseInt(vrv.txtIDVenta.getText()),
                null, null, "Cliente", 0, null, 0,
                Integer.parseInt(vrv.TxtCedula.getText()),
                vrv.TxtNombre.getText(), vrv.txtApellido.getText(),
                vrv.TxtTelefono.getText(), null, vrv.txtDirec.getText()
        );

        JOptionPane.showMessageDialog(null, "Cliente " + vrv.TxtNombre.getText() + " agregado correctamente");
        vrp.setVisible(true);
        vrv.dispose();
    }

    public void generarFactura(int idVenta) {
        Connection conexion = new Conexion().getConexion();
        String query = "SELECT v.numero_factura, p.nombres, p.persona_id, p.direccion, p.numero_telefonico, " +
                       "m.modelo, m.precio_unitario, v.fecha, m.nombre " +
                       "FROM ventas v " +
                       "JOIN personas p ON v.cliente_id = p.persona_id " +
                       "JOIN ventas_motos vm ON v.numero_factura = vm.venta_id " +
                       "JOIN motos m ON vm.moto_id = m.serial_moto " +
                       "WHERE v.numero_factura = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                

                String ruta = "D:\\universidad" + idVenta + ".pdf";

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(ruta));
                document.open();

                document.add(new Paragraph("Factura de Venta"));
                document.add(new Paragraph("Número de Factura: " + rs.getInt("numero_factura")));
                document.add(new Paragraph("Fecha: " + rs.getDate("fecha")));
                document.add(new Paragraph("Cliente: " + rs.getString("nombres")));
                document.add(new Paragraph("Cédula: " + rs.getString("persona_id")));
                document.add(new Paragraph("Dirección: " + rs.getString("direccion")));
                document.add(new Paragraph("Teléfono: " + rs.getString("numero_telefonico")));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph("Detalle de la compra:"));
                document.add(new Paragraph("Nombre moto:" + rs.getString("nombre")));
                document.add(new Paragraph("Modelo: " + rs.getString("modelo")));
                
                String precio = String.format("%.2f", rs.getDouble("precio_unitario")); 
                document.add(new Paragraph("Precio: " + precio));
                
                document.add(new Paragraph("\n"));

                document.close();

                Desktop.getDesktop().open(new File(ruta));

                JOptionPane.showMessageDialog(null, "Factura generada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para la factura " + idVenta, "Error", JOptionPane.ERROR_MESSAGE);
            }
            

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar la factura: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}