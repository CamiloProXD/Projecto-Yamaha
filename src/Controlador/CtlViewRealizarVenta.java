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
import Modelo.DaoPersona;
import Modelo.Persona;
import Vista.ViewAgregarCliente;
import Vista.ViewAgregarMotos;

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
import java.util.Date;
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
    private DaoPersona dPersona;
    private DaoVenta dVenta;
    private Venta venta;
    private Moto moto;
    ViewAgregarCliente vac = new ViewAgregarCliente();
    ViewAgregarMotos vam = new ViewAgregarMotos();

    public CtlViewRealizarVenta(ViewRegistrarpago vrp, ViewRealizarVenta vrv, ViewCerrarSesionEmpleado vcs, DaoUsuario dUsuario, DaoPersona dPersona, DaoVenta dVenta) {
        this.vrp = vrp;
        this.vrv = vrv;
        this.vcs = vcs;
        this.dUsuario = dUsuario;
        this.dPersona = dPersona;
        this.dVenta = dVenta;

        vrv.btnAnadirMoto.addActionListener(this);
        vrv.btnGenerarFactura.addActionListener(this);
        vrv.botonRegresar.addActionListener(this);
        vrv.btnCrearPedido.addActionListener(this);
        vac.btnRegistrarCliente.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vrv.btnCrearPedido)) {
            Persona p = new Persona();
            p.setId(Integer.parseInt(vrv.txtCedulaCliente.getText()));

            if (dPersona.existenciaCliente(p)) {
                mensaje("Cliente Encontrado ", "Correcto");
                Venta pedido = new Venta();
                pedido.setCliente(dPersona.buscarPorId(Integer.parseInt(vrv.txtCedulaCliente.getText())));

                int idVendedor = Integer.parseInt(vrv.txtIdVendedor.getText());
                Usuario vendedor = dUsuario.consultarTrabajadorPorId(idVendedor);

                if (vendedor != null) {
                    pedido.setVendedor(vendedor);
                    pedido.setSucursal(vendedor.getIdSede());
                    pedido.setFecha(new Date());

                    if (dVenta.agregar(pedido)) {
                        mensaje("Pedido agregado correctamente", "Éxito");
                    } else {
                        mensaje("Error al agregar el pedido", "Error");
                    }

                    vrv.EscritorioAgregarMotos.add(vam);
                    vam.setVisible(true);
                } else {
                    mensaje("Vendedor no encontrado", "Error");
                }
            } else {
                mensaje("Cliente No Encontrado ", "Nuevo Cliente");
                vrv.EscritorioAgregarMotos.add(vac);
                vac.setVisible(true);
            }
        }
        if (e.getSource().equals(vac.btnRegistrarCliente)) {
            Persona clienteNuevo = new Persona(
                    Integer.parseInt(vrv.txtCedulaCliente.getText()),
                    vac.txtNombres.getText(),
                    vac.txtApellidos.getText(),
                    vac.txtTelefono.getText(),
                    vac.txtEmail.getText(),
                    vac.txtDireccion.getText()
            );
            dPersona.agregar(clienteNuevo);
            mensaje("Cliente Nuevo Agregado Correctamente ", "EXITO!!!!!");
            this.vac.dispose();
        }

        if (e.getSource().equals(vrv.btnGenerarFactura)) {
            generarFactura(1);
        }

        if (e.getSource().equals(vrv.botonRegresar)) {
            vcs.setVisible(true);
            vrv.dispose();
        }
    }

    public void generarFactura(int idVenta) {
        Connection conexion = new Conexion().getConexion();
        String query = "SELECT v.numero_factura, p.nombres, p.persona_id, p.direccion, p.numero_telefonico, "
                + "m.modelo, m.precio_unitario, v.fecha, m.nombre "
                + "FROM ventas v "
                + "JOIN personas p ON v.cliente_id = p.persona_id "
                + "JOIN ventas_motos vm ON v.numero_factura = vm.venta_id "
                + "JOIN motos m ON vm.moto_id = m.serial_moto "
                + "WHERE v.numero_factura = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String ruta = "D:\\universidad\\3er semestre\\proyecto Yamaha\\" + "Factura de la venta " + idVenta + ".pdf";

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

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
